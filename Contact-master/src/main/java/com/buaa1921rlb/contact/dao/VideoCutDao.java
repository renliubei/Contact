package com.buaa1921rlb.contact.dao;

import com.buaa1921rlb.contact.entity.Video;
import com.buaa1921rlb.contact.entity.VideoCut;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;



public interface VideoCutDao {
    @Select("SELECT * FROM videocut WHERE id = #{id} AND deleted = false")
    VideoCut selectVideoCutByid(@Param("Id") long Id);
    @Select("SELECT COUNT(*) FROM videocut WHERE author_id = #{author} AND deleted = false")
    VideoCut countByAuthor(@Param("author") Integer authorId);
}
