package cn.edu.teacraftsmanship.service.impl;

import cn.edu.teacraftsmanship.mapper.UserMapper;
import cn.edu.teacraftsmanship.pojo.User;
import cn.edu.teacraftsmanship.service.UserService;
import cn.edu.teacraftsmanship.utils.MD5Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static cn.edu.teacraftsmanship.utils.EmailUtils.isEmailValid;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private JavaMailSenderImpl mailSender;

    @Autowired
    private RedisTemplate redisTemplate;

    @Value("${spring.mail.username}")
    private String username;

    @Override
    public String captcha(String email) {
        //判断邮箱是否存在


        if (!isEmailValid(email)){
            return "邮箱号不存在,重新输入";
        }

        //生成验证码
        String captcha = createCaptcha();

        // 创建简单邮件消息对象
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(username);
        mailMessage.setTo(email);  // 设置收件人邮箱
        mailMessage.setSubject("验证码");  // 设置邮件主题
        mailMessage.setText("您的验证码是：" + captcha);  // 设置邮件内容

        try {
            // 发送邮件
            mailSender.send(mailMessage);
            log.info("邮件已成功发送到 {} 邮箱", email);
        } catch (Exception e) {
            log.info("邮件发送失败");
        }

        //储存到数据库
//        LocalTime.now();
//        captchaMapper.Upload(captcha,email, LocalDateTime.now());

        //储存到redis当中
        redisTemplate.opsForValue().set(email,captcha,5, TimeUnit.MINUTES);
        return "验证码已发送到邮箱";
    }

    @Override
    public User login(User user) {
        User u = userMapper.login(user);
        if(u != null) {
            String MD5Code = MD5Utils.MD5Lower(user.getPassword(), u.getSalt());
            System.out.println("md5"+MD5Code);
            System.out.println("密码"+u.getPassword());
            if (MD5Code != null && MD5Code.equals(u.getPassword())) {
                log.info("密码正确");
                return u;
            }
        }
        return null;
    }

    @Override
    public void enroll(User user) {
        user.setSalt(MD5Utils.getSalt());
        String password = MD5Utils.MD5Lower(user.getPassword(), user.getSalt());
        user.setPassword(password);
        userMapper.enroll(user);
    }

    @Override
    public boolean isEnroll(String name) {
        Long id = userMapper.isEnroll(name);
        return id == null;
    }

    @Override
    public void update(User user) {
        userMapper.update(user);
    }

    @Override
    public User getUser(Long id) {
        return userMapper.getUser(id);
    }


    /**
     * 生成验证码
     * @return
     */
    public String createCaptcha(){
        Random r = new Random();
        return String.valueOf(r.nextInt(500000) + 100000);
    }

    /**
     * 判断验证码是否存在
     *
     * @param captcha
     * @param email
     * @return
     */
    @Override
    public Boolean verify(String captcha, String email) {
        return Objects.equals(redisTemplate.opsForValue().get(email), captcha);
    }
}
