package cn.edu.teacraftsmanship.service;

import cn.edu.teacraftsmanship.pojo.Comment;
import cn.edu.teacraftsmanship.pojo.CommentUser;

import java.util.List;

public interface CommentService {
    List<CommentUser> list();
    void save(Comment comment);
    List<CommentUser> getComment(Long id);
}
