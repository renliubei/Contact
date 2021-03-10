package com.buaa1921rlb.contact.dao;

import com.buaa1921rlb.contact.entity.Picture;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Repository
public interface FileDao {

    @SELECT("SELECT * FROM picture WHERE name = #{name}")
    Picture selectPictureByName(@Param("name") String pictureName);

    @INSERT("INSERT INTO picture WHERE name = #{name}, #url = #{url}")
    Integer insertPicture(@Param("name") String pictureName, @Param("url") String pictureUrl);

    @UPDATE("UPDATE picture SET deleted = true WHERE name = #{name}")
    Integer deletePicture(@Param("name") String pictureName);
}
