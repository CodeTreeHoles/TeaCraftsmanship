package cn.edu.teacraftsmanship.service;

import cn.edu.teacraftsmanship.pojo.Track;

import java.util.List;

public interface TrackService {
    List<Track> getTrackByCity(String city);


}
