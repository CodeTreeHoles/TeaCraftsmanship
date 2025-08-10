package cn.edu.teacraftsmanship.controller;


import cn.edu.teacraftsmanship.pojo.Result;
import cn.edu.teacraftsmanship.pojo.Track;
import cn.edu.teacraftsmanship.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tea/track")
public class TrackController {

    @Autowired
    private TrackService trackService;
    @GetMapping("/city")
    public Result<List<Track>> cityList(@RequestParam String city){
        return Result.success(trackService.getTrackByCity(city));
    }
}
