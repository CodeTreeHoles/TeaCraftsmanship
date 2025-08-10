package cn.edu.teacraftsmanship.mapper;

import cn.edu.teacraftsmanship.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {

    @Select("Select * from user where name=#{name}")
    User login(User user);

    @Select("Select id from user where name=#{name}")
    Long isEnroll(String name);

    @Insert("insert into user (name,personal_profile,password,email,salt,sex) values (#{name},#{personalProfile},#{password},#{email},#{salt},#{sex})")
    void enroll(User user);

    @Select("select * from user where id=#{id}")
    User getUser(Long id);

    void update(User user);
}
