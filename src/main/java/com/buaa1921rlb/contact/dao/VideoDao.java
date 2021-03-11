package com.buaa1921rlb.contact.dao;

import com.buaa1921rlb.contact.entity.Video;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Date;
import java.util.List;

@Repository
public interface VideoDao {

    @SELECT("SELECT * FROM video WHERE filename = #{name} AND deleted = false")
    Video selectVideoByFilename(@Param("name") String filename);

    @SELECT("SELECT * FROM video WHERE name_by_user = #{name} AND deleted = false")
    List<Video> selectVideoByName(@Param("name") String nameByUser);

    @SELECT("SELECT COUNT(*) FROM video WHERE author_id = #{author} AND deleted = false")
    Integer countByAuthor(@Param("author") Integer authorId);

    @INSERT("INSERT INTO video(filename, name_by_user, upload_time, url)" +
            "VALUES(#{filename}, #{name}, #{time}, #{url})")
    Integer insertVideo(@Param("filename") String filename,
                        @Param("name") String nameByUser,
                        @Param("time") Date uploadTime,
                        @Param("url") String url);

    @UPDATE("UPDATE video SET deleted = true WHERE filename = #{name}")
    Integer deleteVideo(@Param("name") String filename);
}
