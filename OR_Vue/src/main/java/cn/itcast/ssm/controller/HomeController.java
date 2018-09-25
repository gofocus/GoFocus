package cn.itcast.ssm.controller;

import cn.itcast.ssm.po.*;
import cn.itcast.ssm.service.ItemsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 2016-11-11 16:39
 */

@Controller
public class HomeController {

    @Autowired
    private ItemsService itemsService;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String home_get(Model model, HttpSession httpSession, ItemsQueryVo itemsQueryVo) throws Exception {

        List<ItemsCustom> itemList = itemsService.findItemsList(itemsQueryVo);
        model.addAttribute("itemList", itemList);

        Subject subject = SecurityUtils.getSubject();
        ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
        httpSession.setAttribute("activeUser",activeUser);
        model.addAttribute("activeUser", activeUser);

        return "index";
    }

    @RequestMapping(value = "/ajaxIndex")
    public String ajax_index(Model model,ItemsQueryVo itemsQueryVo) throws Exception {
        List<ItemsCustom> itemsList = itemsService.findItemsByParam(itemsQueryVo);
        model.addAttribute("itemList", itemsList);
        return "ajaxIndex";
    }





}




