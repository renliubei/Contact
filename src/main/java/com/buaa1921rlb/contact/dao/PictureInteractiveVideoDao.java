package com.buaa1921rlb.contact.dao;

import com.buaa1921rlb.contact.entity.Picture;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Date;
import java.util.List;

@Repository
public interface PictureInteractiveVideoDao {

    @Select("SELECT * FROM picture_interactive_video WHERE filename = #{name} AND deleted = false")
    Picture selectPictureByFileName(@Param("name") String filename);

    @Select("SELECT * FROM picture_interactive_video WHERE name_by_user = #{name} AND deleted = false")
    List<Picture> selectPictureByName(@Param("name") String nameByUser);

    @Select("SELECT * FROM picture_interactive_video WHERE author_id = #{id} AND deleted = false")
    List<Picture> selectPictureByAuthor(@Param("id") Integer authorId);

    @Insert("INSERT INTO picture_interactive_video (filename, name_by_user, upload_time, url) " +
            "VALUES (#{name}, #{url}, #{name_bu_user}, #{upload_time})")
    Integer insertPicture(@Param("name") String filename,
                          @Param("url") String pictureUrl,
                          @Param("name_by_user") String nameByUser,
                          @Param("upload_time") Date uploadTime);

    @Update("UPDATE picture_interactive_video SET deleted = true WHERE filename = #{name}")
    Integer deletePicture(@Param("name") String filename);
}
