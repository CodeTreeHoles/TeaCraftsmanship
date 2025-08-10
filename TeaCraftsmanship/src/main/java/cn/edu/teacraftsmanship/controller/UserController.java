package cn.edu.teacraftsmanship.controller;

import cn.edu.teacraftsmanship.pojo.Result;
import cn.edu.teacraftsmanship.pojo.User;
import cn.edu.teacraftsmanship.service.UserService;
import cn.edu.teacraftsmanship.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@Slf4j
@RequestMapping("/tea/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public Result<User> user(@PathVariable Long id){
        User user = userService.getUser(id);
        user.setSalt("");
        user.setPassword("");
        user.setEmail("");
        return Result.success(user);
    }

    @PutMapping("/update")
    public Result<String> update(@RequestBody User user){
        log.info("修改的用户信息:{}",user);
        userService.update(user);
        return null;
    }
    @PostMapping("/login")
    public Result<Object> login(@RequestBody User user){


        Map<String,Object> claims = null;

        User u = userService.login(user);

        //获取到的用户为空的情况下，视为登录失败
        if(u != null){
            Long id = u.getId();
            String password = u.getPassword();


            claims = new HashMap<>();

            //生成jwt令牌
            claims.put("id",id);
            claims.put("password",password);

            String jwt = JwtUtils.generateJwt(claims);

            Map<String, Object> data = new HashMap<>();

            //上传用户信息
            data.put("avatar",u.getAvatarUrl());
            data.put("id", id);
            data.put("jwt", jwt);


            return Result.success(data);
        }
        return Result.error("登录失败");
    }

    @PostMapping("/enroll")
    public Result<String> enroll(@RequestBody User user,@RequestParam String captcha){
        log.info("注册操作，参数:{},{}",user,captcha);
        if(!userService.isEnroll(user.getName())){
            log.info("用户名重复");
            return Result.error("用户名已经被注册");
        }

        if(Objects.equals(captcha, "")){
            return Result.error("验证码为空");
        }
        if(Objects.equals(user.getName(), "") || Objects.equals(user.getPassword(), "")){
            return Result.error("用户信息为空");
        }
        if(userService.verify(captcha,user.getEmail())){
            //判断验证码是否合法
            log.info("验证码合法");
            userService.enroll(user);
        }else {
            return Result.error("验证码错误");
        }
        return Result.success("注册成功");
    }


    /**
     * 生成验证码，发送到指定的邮箱
     * @return
     */
    @PostMapping("/enroll/captcha")
    public Result Captcha(@RequestBody String email){
        email = email.substring(1, email.length()-1);
        log.info("生成验证码，发送到邮箱号:{}",email);
        return Result.success(userService.captcha(email));
    }
}