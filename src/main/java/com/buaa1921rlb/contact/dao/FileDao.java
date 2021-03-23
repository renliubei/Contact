package com.buaa1921rlb.contact.dao;

import com.buaa1921rlb.contact.entity.MyFile;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileDao {

    @Select("SELECT * FROM file WHERE name_by_user = #{name} AND author_id = #{id} AND deleted = false")
    List<MyFile> selectFileByName(@Param("name") String nameByUser, @Param("id") Integer userId);

    @Select("SELECT * FROM file WHERE id = #{id} AND deleted = false")
    @Results({
            @Result(column = "name_by_user", property = "nameByUser"),
            @Result(column = "upload_time", property = "uploadTime"),
            @Result(column = "author_id", property = "authorId"),
            @Result(column = "file_type", property = "fileType")
    })
    MyFile selectFileById(@Param("id") Integer fileId);

    @Select("SELECT COUNT(*) FROM file WHERE file_type = #{type} AND deleted = false AND author_id = #{id}")
    Integer countByAuthorAndType(@Param("type") int fileType, @Param("id") Integer authorId);

    @Insert("INSERT INTO file(filename, name_by_user, upload_time, url, author_id, file_type) " +
            "VALUES(#{filename}, #{nameByUser}, #{uploadTime}, #{url}, #{authorId}, #{fileType})")
    Integer insertFile(MyFile myFile);

    @Update("UPDATE file SET deleted = true WHERE id = #{id}")
    Integer deleteById(@Param("id") Integer fileId);
}
