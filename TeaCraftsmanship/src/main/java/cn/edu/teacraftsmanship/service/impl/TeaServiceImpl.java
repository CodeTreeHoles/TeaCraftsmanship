package cn.edu.teacraftsmanship.service.impl;

import cn.edu.teacraftsmanship.mapper.TeaMapper;
import cn.edu.teacraftsmanship.pojo.Tea;
import cn.edu.teacraftsmanship.service.TeaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeaServiceImpl implements TeaService {
    @Autowired
    private TeaMapper teaMapper;
  public Tea getTeaById(Long id) {
        return teaMapper.getTeaById(id);
    }

    @Override
    public List<Tea> getAllTeas() {
        return teaMapper.getAllTeas();
    }


}