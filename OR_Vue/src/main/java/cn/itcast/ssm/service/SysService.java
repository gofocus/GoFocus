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

    SysUser findUserByUsercode(String usercode);

    List<SysPermission> findPermissionListByUserId(int userid);

    void updateByPrimaryKeySelective(SysUser sysUser);

    Userdetail findUserdetailByUser_id(int user_id);

//    Boolean authenticate(String username, String password );
}
