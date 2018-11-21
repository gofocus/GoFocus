package cn.itcast.ssm.controller;

import cn.itcast.ssm.exception.CustomException;
import cn.itcast.ssm.po.*;
import cn.itcast.ssm.service.ItemsService;
import cn.itcast.ssm.service.SysService;
import cn.itcast.ssm.utils.Constants;
import cn.itcast.ssm.utils.MD5_test;
//import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Array;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.*;


/**
 * Created by gofocus on 2017/3/19.
 */


@Controller
@RequestMapping("/user")
public class UserController {
    private static final Logger logger = LogManager.getLogger(UserController.class.getName());

    @Autowired
    private SysService sysService;

    @Autowired
    private ItemsService itemsService;


    //注册页面
/*    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerGet(){
        return "sysUser/register";
    }*/

    //提交注册信息，写入数据库
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public SysUser registerPost(SysUser SysUser) {
        sysService.addUser(SysUser);
        return SysUser;
    }

    @RequestMapping(value = "/loginTest", method = RequestMethod.POST)
    @ResponseBody
    public Map loginTest(HttpServletRequest request, @RequestBody LoginUser loginUser) {

//        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(loginUser);
//        String s = (String) jsonObject.get("email");

        HashMap<String, LoginUser> map = new HashMap();
        map.put("user", loginUser);

        return map;

    }

    //使用shiro认证用户
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public boolean login(HttpServletRequest request) throws Exception {

        //如果登陆失败从request中获取认证异常信息，shiroLoginFailure就是shiro异常类的全限定名
        String exceptionClassName = (String) request.getAttribute("shiroLoginFailure");

        Subject subject = SecurityUtils.getSubject();
        return subject.isAuthenticated();

        //根据shiro返回的异常类路径判断，抛出指定异常信息
/*        if (exceptionClassName != null) {
            if (UnknownAccountException.class.getName().equals(exceptionClassName)) {
                //最终会抛给异常处理器
//                return ;
                throw new CustomException("账号不存在");
            } else if (IncorrectCredentialsException.class.getName().equals(
                    exceptionClassName)) {
//                return ;
                throw new CustomException("用户名/密码错误");
                } else if("randomCodeError".equals(exceptionClassName)){
                    throw new CustomException("验证码错误 ");
            } else {
//                return ;
                throw new Exception();//最终在异常处理器生成未知错误
            }
        }*/

        //!!!此方法不处理登陆成功（认证成功），shiro认证成功会自动跳转到上一个请求路径

        //登陆失败还到login页面
//        return "sysUser/login";
    }


    @RequestMapping(value = "/currentUser")
    @ResponseBody
    public ActiveUser currentUser() {
        Subject subject = SecurityUtils.getSubject();
        return (ActiveUser) subject.getPrincipal();
    }

    //get修改密码页面
    @RequestMapping(value = "/modify_password", method = RequestMethod.GET)
    public String modify_password() {
        return "sysUser/modify_password";
    }

    //POST修改密码，通过表格传入新密码，转换为Md5后写入数据库
    @RequestMapping(value = "/modify_password", method = RequestMethod.POST)
    public String modify_password_post(String new_password) {

        //将表格中的密码转换为Md5形式
        String md5_password = MD5_test.getMd5(new_password);

        //拿到当前认证用户的id
        Subject subject = SecurityUtils.getSubject();
        ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
        SysUser sysUser = new SysUser();
        sysUser.setId(activeUser.getUserid());

        //通过当前用户的id将新密码写入数据库
        sysUser.setPassword(md5_password);
        sysService.updateByPrimaryKeySelective(sysUser);

        return "redirect:/";
    }


    //注册用户时，验证用户名是否已经存在
    @RequestMapping("/validate_usercode")
    //必须要加@ResponseBody,否则remote[]验证结果永远为false
    @ResponseBody
    public boolean validate_usercode(String usercode) {
        return (sysService.findUserByUserCode(usercode) == null);
    }

    //ajax验证修改密码时输入的原密码的正确性
    @RequestMapping("/validate_password")
    @ResponseBody
    public Boolean validate_password(String opwd) {

        //拿到用户输入的密码，并转换为md5
        String md5_password = MD5_test.getMd5(opwd);

        //从当前登录用户的缓存中拿到用户的账号
        Subject subject = SecurityUtils.getSubject();
        ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
        String usercode = activeUser.getUsercode();

        //从数据库拿到用户的密码
        SysUser sysUser = sysService.findUserByUserCode(usercode);
        String db_password = sysUser.getPassword();

        //判断两个密码相等则返回true，不相等返回false
        return (db_password.equals(md5_password));

    }


    //用户详细信息
    @RequestMapping("/user_detail/{user_id}")
    public String user_detail(@PathVariable int user_id, Model model) {

        Userdetail userdetailByUser_id = sysService.findUserdetailByUser_id(user_id);

        if (userdetailByUser_id.getSex().equals("1")) {
            userdetailByUser_id.setSex("男");
        } else userdetailByUser_id.setSex("女");

        model.addAttribute("userdetail", userdetailByUser_id);

        return "sysUser/user_detail";

    }


}
