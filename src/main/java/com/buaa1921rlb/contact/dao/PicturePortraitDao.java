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
public interface PicturePortraitDao {

    @SELECT("SELECT * FROM picture_portrait WHERE filename = #{name} AND deleted = false")
    Picture selectPictureByFileName(@Param("name") String filename);

    @SELECT("SELECT * FROM picture_portrait WHERE name_by_user = #{name} AND deleted = false")
    List<Picture> selectPictureByName(@Param("name") String nameByUser);

    @SELECT("SELECT * FROM picture_portrait WHERE author_id = #{id} AND deleted = false")
    List<Picture> selectPictureByAuthor(@Param("id") Integer authorId);

    @INSERT("INSERT INTO picture_portrait (filename, name_by_user, upload_time, url) " +
            "VALUES (#{name}, #{name_bu_user}, #{upload_time}, #{url})")
    Integer insertPicture(@Param("name") String filename,
                          @Param("url") String pictureUrl,
                          @Param("name_by_user") String nameByUser,
                          @Param("upload_time")Date uploadTime);

    @UPDATE("UPDATE picture_portrait SET deleted = true WHERE filename = #{name}")
    Integer deletePicture(@Param("name") String filename);
}
