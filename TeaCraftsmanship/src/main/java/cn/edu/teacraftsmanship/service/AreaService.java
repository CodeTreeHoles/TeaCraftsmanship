package cn.edu.teacraftsmanship.service;

import cn.edu.teacraftsmanship.pojo.Area;

public interface AreaService {
    Area getAreaById(Long id);
    Area getAreaByName(String name);
}
