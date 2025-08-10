package cn.edu.teacraftsmanship.service.impl;

import cn.edu.teacraftsmanship.mapper.TeaContentMapper;
import cn.edu.teacraftsmanship.mapper.TeaMakeMapper;
import cn.edu.teacraftsmanship.pojo.TeaContent;
import cn.edu.teacraftsmanship.pojo.TeaMake;
import cn.edu.teacraftsmanship.service.TeaContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeaContentServiceImpl implements TeaContentService {

    @Autowired
    private TeaContentMapper teaContentMapper;

    @Autowired
    private TeaMakeMapper teaMakeMapper;

    @Override
    public TeaContent getTeaContent(Long id) {
        return teaContentMapper.getContent(id);
    }

    @Override
    public TeaMake getTeaMake(Long id) {
        return teaMakeMapper.getTeaMake(id);
    }
}
