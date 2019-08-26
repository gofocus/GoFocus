package cn.itcast.ssm.controller;

import cn.itcast.ssm.po.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 2016-11-11 16:39
 */

@Controller
public class HomeController {


    @RequestMapping(value = "/",method = RequestMethod.GET)
    @ResponseBody
//    public String home_get(Model model, HttpSession httpSession, ItemsQueryVo itemsQueryVo) throws Exception {
    public void home_get(Model model, HttpSession httpSession) throws Exception {
        Subject subject = SecurityUtils.getSubject();
        ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
        httpSession.setAttribute("activeUser",activeUser);
        model.addAttribute("activeUser", activeUser);


    }


}




