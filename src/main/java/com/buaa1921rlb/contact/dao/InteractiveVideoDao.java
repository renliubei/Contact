package com.buaa1921rlb.contact.dao;

import com.buaa1921rlb.contact.entity.InteractiveVideo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface InteractiveVideoDao {

    @Select("SELECT * FROM interactive_video WHERE id = #{id}")
    InteractiveVideo selectById(@Param("id") String id);

    @Select("SELECT * FROM interactive_video WHERE name = #{name}")
    InteractiveVideo selectByName(@Param("name") String name);

    @Select("SELECT * FROM interactive_video WHERE author_id = #{author}")
    List<InteractiveVideo> selectByAuthor(@Param("author") String authorId);

    @Insert("INSERT INTO interactive_video(name, author_id, logic_tree) VALUES (#{name}, " +
            "#{author_id}, #{logic_tree})")
    Integer insert(@Param("name") String name, @Param("author_id") String authorId,
                   @Param("logic_tree") String logicTree);

    @Update("UPDATE interactive_video SET logic_tree = #{logic_tree} WHERE id = #{id}")
    Integer updateLogicTree(@Param("id") String interactiveVideoId, @Param("logic_tree") String logicTree);
}
