package cn.itcast.ssm.mapper;

import cn.itcast.ssm.po.SysPermission;

import java.util.List;

/**
 * Created by gofocus on 2017/3/290:24.
 */
public interface SysPermissionMapperCustom {

    List<SysPermission> findPermissionListByUserId(int userId);

    List<SysPermission> findMenuListByUserId(int userId);


}
