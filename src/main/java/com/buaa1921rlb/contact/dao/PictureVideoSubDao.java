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
public interface PictureVideoSubDao {

    @SELECT("SELECT * FROM picture_video_sub WHERE filename = #{name} AND deleted = false")
    Picture selectByFileName(@Param("name") String filename);

    @SELECT("SELECT * FROM picture_video_sub WHERE name_by_user = #{name} AND deleted = false")
    List<Picture> selectByName(@Param("name") String nameByUser);

    @SELECT("SELECT * FROM picture_video_sub WHERE author_id = #{id} AND deleted = false")
    List<Picture> selectPictureByAuthor(@Param("id") Integer authorId);

    @INSERT("INSERT INTO picture_video_sub(filename, name_by_user, upload_time, url) " +
            "VALUES(#{name}, #{name_by_user}, #{upload_time}, #{url})")
    Integer insertPicture(@Param("name") String filename,
                          @Param("name_by_user") String nameByUser,
                          @Param("upload_time")Date uploadTime,
                          @Param("url") String url);

    @UPDATE("UPDATE picture_video_sub SET deleted = true WHERE filename = #{name}")
    Integer deletePicture(@Param("name") String filename);
}
