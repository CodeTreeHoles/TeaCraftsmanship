package cn.edu.teacraftsmanship.service.impl;

import cn.edu.teacraftsmanship.mapper.CommentMapper;
import cn.edu.teacraftsmanship.pojo.Comment;
import cn.edu.teacraftsmanship.pojo.CommentUser;
import cn.edu.teacraftsmanship.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;
    @Override
    public List<CommentUser> list() {
        List<CommentUser> list = commentMapper.UnionSuperiorComment();
        log.info("{}",list);
        return list;
    }

    @Override
    public void save(Comment comment) {
        log.info("{}",comment);
        commentMapper.save(comment);
    }
    public List<CommentUser> getComment(Long id){
        return commentMapper.UnionSubordinateComment(id);
    }
}
