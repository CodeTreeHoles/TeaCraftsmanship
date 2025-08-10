package cn.edu.teacraftsmanship;

import cn.edu.teacraftsmanship.mapper.CommentMapper;
import cn.edu.teacraftsmanship.pojo.Comment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TeaCraftsmanshipApplicationTest {

    @Autowired
    private CommentMapper commentMapper;
//
//    @Test
//    public void test(){
//        Comment comment = new Comment();
//        comment.setContent("测试数据二");
//        comment.setId(2L);
//        commentMapper.save(comment);
//    }

}