package cn.edu.teacraftsmanship.mapper;

import cn.edu.teacraftsmanship.pojo.Track;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TrackMapper {

    @Select("SELECT * FROM track where city=#{city}")
    List<Track> getTrackByCity(String city);
}