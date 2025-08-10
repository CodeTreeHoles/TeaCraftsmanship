package cn.edu.teacraftsmanship.service.impl;

import cn.edu.teacraftsmanship.mapper.AreaMapper;
import cn.edu.teacraftsmanship.pojo.Area;
import cn.edu.teacraftsmanship.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaMapper areaMapper;

    @Override
    public Area getAreaById(Long id) {
        return areaMapper.getAreaById(id);
    }

    @Override
    public Area getAreaByName(String name) {
        return areaMapper.getAreaByName(name);
    }
}
