package cn.itcast.ssm.shiro;

import cn.itcast.ssm.po.ActiveUser;
import cn.itcast.ssm.po.SysPermission;
import cn.itcast.ssm.po.SysUser;
import cn.itcast.ssm.service.SysService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

/**
 * Created by gofocus on 2017/3/27.
 */
public class CustomRealm extends AuthorizingRealm {
    private static final Logger logger = LogManager.getLogger(CustomRealm.class.getName());

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

        String userCode = (String) authenticationToken.getPrincipal();
        SysUser sysUser = sysService.findUserByUserCode(userCode);

        if (sysUser == null)
            return null;
        else {

            String password = sysUser.getPassword();
            String salt = sysUser.getSalt();

            ActiveUser activeUser = new ActiveUser();
            activeUser.setUserid(sysUser.getId());
            activeUser.setUsercode(sysUser.getUsercode());
            activeUser.setUsername(sysUser.getUsername());
            activeUser.setMenus(sysService.findMenuListByUserId(sysUser.getId()));

            logger.debug(activeUser.getUsercode());

            return new SimpleAuthenticationInfo(activeUser, password, ByteSource.Util.bytes(salt), this.getName());
        }
    }

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        //从principal获取主身份信息
        // 将getPrimaryPrincipal方法返回值转为真实身份类型（在上边的doGetAuthenticationInfo认证通过填充到SimpleAuthenticationInfo中身份类型）
        ActiveUser activeUser = (ActiveUser) principalCollection.getPrimaryPrincipal();

        // 根据身份信息获取权限信息
        // 从数据库获取到权限数据
        List<SysPermission> permissionListByUserId = sysService.findPermissionListByUserId(activeUser.getUserid());

        List<String> permissionList = new ArrayList<>();
        if (permissionListByUserId != null) {
            for (SysPermission permission : permissionListByUserId) {
                permissionList.add(permission.getPercode());
            }
        }

        //将授权信息填充到simpleAuthorizationInfo对象中
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addStringPermissions(permissionList);

        return simpleAuthorizationInfo;
    }
}
