package cn.itcast.ssm.service;

import cn.itcast.ssm.po.SysPermission;
import cn.itcast.ssm.po.SysUser;
import cn.itcast.ssm.po.Userdetail;

import java.util.List;

/**
 * Created by gofocus on 2017/3/25.
 */

public interface SysService {

    void addUser(SysUser user);

    SysUser findUserById(int id);

    SysUser findUserByUserCode(String userCode);

    List<SysPermission> findPermissionListByUserId(int userId);

    List<SysPermission> findMenuListByUserId(int userId);

    void updateByPrimaryKeySelective(SysUser sysUser);

    Userdetail findUserdetailByUser_id(int user_id);

//    Boolean authenticate(String username, String password );
}
