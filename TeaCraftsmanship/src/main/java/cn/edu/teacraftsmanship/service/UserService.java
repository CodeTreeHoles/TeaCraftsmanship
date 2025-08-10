package cn.edu.teacraftsmanship.service;

import cn.edu.teacraftsmanship.pojo.User;

public interface UserService {

    String captcha(String email);
    User login(User user);
    void enroll(User user);
    boolean isEnroll(String name);
    void update(User user);
    User getUser(Long id);
    Boolean verify(String captcha, String email);

}
