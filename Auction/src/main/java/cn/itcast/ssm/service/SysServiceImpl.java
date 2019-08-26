package cn.itcast.ssm.service;

import cn.itcast.ssm.mapper.SysPermissionMapperCustom;
import cn.itcast.ssm.mapper.SysUserMapper;
import cn.itcast.ssm.mapper.UserdetailMapper;
import cn.itcast.ssm.po.*;
import cn.itcast.ssm.utils.MD5;
import cn.itcast.ssm.utils.MD5_test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by gofocus on 2017/3/25.
 */


@Service
public class SysServiceImpl implements SysService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private UserdetailMapper userdetailMapper;

    @Autowired
    private SysPermissionMapperCustom sysPermissionMapperCustom;

    @Override
    public void addUser(SysUser user) {

        String password_md5 = MD5_test.getMd5(user.getPassword());
        user.setPassword(password_md5);
        user.setSalt("qwerty");
        user.setLocked("0");

        sysUserMapper.insert(user);
    }

    @Override
    public SysUser findUserById(int id) {
        SysUser sysUser = sysUserMapper.selectByPrimaryKey(id);
        return sysUser;
    }

    @Override
    public SysUser findUserByUserCode(String userCode) {
        SysUserExample sysUserExample = new SysUserExample();
        SysUserExample.Criteria criteria = sysUserExample.createCriteria();
        criteria.andUsercodeEqualTo(userCode);
        List<SysUser> list = sysUserMapper.selectByExample(sysUserExample);

        if (list != null && list.size() > 0) {
           return list.get(0);
        }
        return null;
    }

    @Override
    public List<SysPermission> findPermissionListByUserId(int userId) {
        return sysPermissionMapperCustom.findPermissionListByUserId(userId);
    }

    @Override
    public List<SysPermission> findMenuListByUserId(int userId) {
        return sysPermissionMapperCustom.findMenuListByUserId(userId);
    }

    @Override
    public void updateByPrimaryKeySelective(SysUser sysUser) {
        sysUserMapper.updateByPrimaryKeySelective(sysUser);
    }

    @Override
    public Userdetail findUserdetailByUser_id(int user_id) {
        UserdetailExample userdetailExample = new UserdetailExample();
        UserdetailExample.Criteria criteria = userdetailExample.createCriteria();
        criteria.andUserIdEqualTo(user_id);
        List<Userdetail> userdetails = userdetailMapper.selectByExample(userdetailExample);

        if (userdetails !=null && userdetails.size()>0){
            return userdetails.get(0);
        }

        return null;
    }

}
