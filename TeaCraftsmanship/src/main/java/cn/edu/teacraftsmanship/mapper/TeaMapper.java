package cn.edu.teacraftsmanship.mapper;

import cn.edu.teacraftsmanship.pojo.Tea;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TeaMapper {
    @Select("select * from tea where id =#{id}")
    Tea getTeaById(Long id);
    @Select("SELECT * FROM tea")
    List<Tea> getAllTeas();
}