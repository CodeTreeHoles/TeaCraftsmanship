package cn.edu.teacraftsmanship.controller;

import cn.edu.teacraftsmanship.utils.AliOssUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@Slf4j
@RequestMapping("/tea")
public class AvatarUploadController {

    // 使用Spring的@Value注解来注入配置属性
    
    // 上传文件,返回文件的公网访问地址
    @PostMapping("/avatar/upload")
    public String uploadAvatar(@RequestParam("file") MultipartFile file) throws IOException {
        // 使用AliOssUtil的静态方法上传文件

        log.info("文件上传中......");
        String objectName = "avatars/" + file.getOriginalFilename();
        String url = AliOssUtil.uploadFile(objectName, file.getInputStream());
        // 返回文件路径给前端
        return url;
    }
}
