package cn.itcast.ssm.service;

import cn.itcast.ssm.po.Classes;
import cn.itcast.ssm.po.ClassesExample;

import java.util.List;

/**
 * Created by gofocus on 2018/1/24 15:56.
 */
public interface ClassesService {
    List<Classes> selectById(Integer id);

}
