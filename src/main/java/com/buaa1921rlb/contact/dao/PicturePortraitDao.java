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

    @SELECT("SELECT * FROM picture_portrait WHERE file_name = #{name} AND deleted = false")
    Picture selectPictureByFileName(@Param("name") String fileName);

    @SELECT("SELECT * FROM picture_portrait WHERE file_name_by_user = #{name} AND deleted = false")
    List<Picture> selectPictureByName(@Param("name") String nameByUser);

    @INSERT("INSERT INTO picture_portrait (file_name, name_by_user, upload_time, url) " +
            "VALUES (#{name}, #{url}, #{name_bu_user}, #{upload_time})")
    Integer insertPicture(@Param("name") String fileName,
                          @Param("url") String pictureUrl,
                          @Param("name_by_user") String nameByUser,
                          @Param("upload_time")Date uploadTime);

    @UPDATE("UPDATE picture_portrait SET deleted = true WHERE file_name = #{name}")
    Integer deletePicture(@Param("name") String fileName);
}
