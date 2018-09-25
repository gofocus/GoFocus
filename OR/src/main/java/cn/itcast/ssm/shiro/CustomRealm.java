package cn.itcast.ssm.shiro;

import cn.itcast.ssm.po.ActiveUser;
import cn.itcast.ssm.po.SysPermission;
import cn.itcast.ssm.po.SysUser;
import cn.itcast.ssm.service.SysService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by gofocus on 2017/3/27.
 */
public class CustomRealm extends AuthorizingRealm {

    @Autowired
    private SysService sysService;

    // 设置realm的名称
    @Override
    public void setName(String name) {
        super.setName("customRealm");
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        String usercode = (String) authenticationToken.getPrincipal();
        SysUser sysUser = sysService.findUserByUsercode(usercode);

        if (sysUser == null){
            return null;
        }

        String password = sysUser.getPassword();
        String salt = sysUser.getSalt();

        ActiveUser activeUser = new ActiveUser();
        activeUser.setUserid(sysUser.getId());
        activeUser.setUsercode(sysUser.getUsercode());
        activeUser.setUsername(sysUser.getUsername());

        return new SimpleAuthenticationInfo(
                activeUser, password, ByteSource.Util.bytes(salt),this.getName());

    }

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        //从principal获取主身份信息
        ActiveUser activeUser = (ActiveUser) principalCollection.getPrimaryPrincipal();


        List<SysPermission> permissionListByUserId = sysService.findPermissionListByUserId(activeUser.getUserid());

        List<String> permissionList = new ArrayList<>();

        if (permissionListByUserId!=null){
            for (SysPermission permission:permissionListByUserId){
                permissionList.add(permission.getPercode());
            }
        }

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

        simpleAuthorizationInfo.addStringPermissions(permissionList);

        return simpleAuthorizationInfo;
    }
}
