package cn.itcast.ssm.service;

import cn.itcast.ssm.mapper.ClassesMapper;
import cn.itcast.ssm.po.Classes;
import cn.itcast.ssm.po.ClassesExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by gofocus on 2018/1/24 15:57.
 */

@Service
public class ClassesServiceImpl implements ClassesService {

    @Autowired
    private ClassesMapper classesMapper;

    @Override
    public List<Classes> selectById(Integer id) {
        ClassesExample classesExample = new ClassesExample();
        if (id!=null) {
            ClassesExample.Criteria criteria = classesExample.createCriteria();
            criteria.andIdEqualTo(id);
        }
        return classesMapper.selectByExample(classesExample);
    }
}
