package cn.edu.teacraftsmanship.controller;

import cn.edu.teacraftsmanship.pojo.Area;
import cn.edu.teacraftsmanship.pojo.Result;
import cn.edu.teacraftsmanship.service.AreaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/tea/area")
public class AreaController {

    @Autowired
    private AreaService areaService;

    @GetMapping("/{id}")
    public Result<Area> getAreaById(@PathVariable Long id){
        return Result.success(areaService.getAreaById(id));
    }
    @GetMapping("")
    public Result<Area> getAreaById(@RequestParam String name){
        return Result.success(areaService.getAreaByName(name));
    }
}