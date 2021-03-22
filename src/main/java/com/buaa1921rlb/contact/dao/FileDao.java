package com.buaa1921rlb.contact.dao;

import com.buaa1921rlb.contact.entity.MyFile;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileDao {

    @Select("SELECT * FROM file WHERE name_by_user = #{name} AND author_id = #{id} AND deleted = false")
    List<MyFile> selectFileByName(@Param("name") String nameByUser, @Param("id") Integer userId);

    @Select("SELECT * FROM file WHERE id = #{id} AND deleted = #{false}")
    MyFile selectFileById(@Param("id") Integer fileId);

    @Select("SELECT COUNT(*) FROM file WHERE file_type = #{type} AND deleted = false AND author_id = #{id}")
    Integer countByAuthorAndType(@Param("type") int fileType, @Param("id") Integer authorId);

    @Insert("INSERT INTO file(filename, name_by_user, description, upload_time, url, author_id, file_type) " +
            "VALUES(#{file})")
    Integer insertFile(@Param("file") MyFile myFile);

    @Update("UPDATE file SET deleted = true WHERE id = #{id}")
    Integer deleteById(@Param("id") Integer fileId);
}
