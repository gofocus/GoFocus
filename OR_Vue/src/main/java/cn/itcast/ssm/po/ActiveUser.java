package cn.itcast.ssm.po;

import java.io.Serializable;
import java.util.List;

/**
 * Created by gofocus on 2017/3/25.
 */
public class ActiveUser implements Serializable {

    private int userid;
    private String usercode;
    private String username;
    private List<SysPermission> permissions;
    private List<SysPermission> menus;


    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<SysPermission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<SysPermission> permissions) {
        this.permissions = permissions;
    }

    public List<SysPermission> getMenus() {
        return menus;
    }

    public void setMenus(List<SysPermission> menus) {
        this.menus = menus;
    }
}
