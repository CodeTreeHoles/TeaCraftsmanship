package cn.edu.teacraftsmanship.controller;

import cn.edu.teacraftsmanship.pojo.Result;
import cn.edu.teacraftsmanship.pojo.TeaContent;
import cn.edu.teacraftsmanship.pojo.TeaMake;
import cn.edu.teacraftsmanship.service.TeaContentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RequestMapping("/tea/content")
@RestController
@Slf4j
public class TeaContentController {

    @Autowired
    private TeaContentService teaContentService;

    @GetMapping("/{id}")
    public Result<TeaContent> getContent(@PathVariable Long id){
        TeaContent teaContent = teaContentService.getTeaContent(id);
        log.info("{}",teaContent);
        return Result.success(teaContent);
    }

    @GetMapping("/make/{id}")
    public Result<List<String>> getMake(@PathVariable Long id) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        TeaMake teaMake = teaContentService.getTeaMake(id);
        List<String> stepList = teaMake.getStepAll();
        return Result.success(stepList);
    }
}
