package cn.edu.teacraftsmanship.service;

import cn.edu.teacraftsmanship.pojo.TeaContent;
import cn.edu.teacraftsmanship.pojo.TeaMake;

public interface TeaContentService {

    TeaContent getTeaContent(Long id);
    TeaMake getTeaMake(Long id);
}
