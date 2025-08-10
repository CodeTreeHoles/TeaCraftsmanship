package cn.edu.teacraftsmanship.mapper;

import cn.edu.teacraftsmanship.pojo.Area;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AreaMapper {

    @Select("select * from area where id=#{id}")
    Area getAreaById(Long id);

    @Select("select * from area where name=#{name}")
    Area getAreaByName(String name);
}
