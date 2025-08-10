package cn.edu.teacraftsmanship.service;

import cn.edu.teacraftsmanship.pojo.Tea;

import java.util.List;

public interface TeaService {
    Tea getTeaById(Long id);

    List<Tea> getAllTeas();
}
