package cn.edu.teacraftsmanship.mapper;

import cn.edu.teacraftsmanship.pojo.Comment;
import cn.edu.teacraftsmanship.pojo.CommentUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CommentMapper {
    @Select("SELECT * FROM comment")
    List<Comment> list();

    @Select("SELECT comment.*,user.name as user_name " +
            "FROM comment " +
            "join user " +
            "on comment.user_id = user.id " +
            "where pid is null")
    List<CommentUser> UnionSuperiorComment();

    @Select("SELECT comment.*,user.name as user_name " +
            "FROM comment " +
            "join user " +
            "on comment.user_id = user.id " +
            "where comment.pid=#{id}")
    List<CommentUser> UnionSubordinateComment(Long id);
    @Insert("INSERT INTO comment (content,user_id,pid,target) values (#{content},#{userId},#{pid},#{target})")
    void save(Comment comment);
}
