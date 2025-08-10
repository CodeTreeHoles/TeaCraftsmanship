package cn.edu.teacraftsmanship.service.impl;

import cn.edu.teacraftsmanship.mapper.TrackMapper;
import cn.edu.teacraftsmanship.pojo.Track;
import cn.edu.teacraftsmanship.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackServiceImpl implements TrackService {

    @Autowired
    private TrackMapper trackMapper;

    @Override
    public List<Track> getTrackByCity(String city) {
        return trackMapper.getTrackByCity(city);
    }



}
