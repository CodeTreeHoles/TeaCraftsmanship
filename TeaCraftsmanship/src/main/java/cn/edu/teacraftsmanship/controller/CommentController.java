package cn.edu.teacraftsmanship.controller;

import cn.edu.teacraftsmanship.pojo.Comment;
import cn.edu.teacraftsmanship.pojo.CommentUser;
import cn.edu.teacraftsmanship.pojo.Result;
import cn.edu.teacraftsmanship.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/tea/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @GetMapping("/list")
    public Result<List<CommentUser>> list(){
        List<CommentUser> list = commentService.list();
        return Result.success(list);
    }

    @PostMapping()
    public Result<String> save(@RequestBody Comment comment){
        try {
            log.info("{}",comment);
            commentService.save(comment);
            return null;
        } catch (Exception e) {
            return Result.error("发送失败");
        }
    }

    @GetMapping("/{id}")
    public Result<List<CommentUser>> getComment(@PathVariable Long id){
        return Result.success(commentService.getComment(id));
    }
}
