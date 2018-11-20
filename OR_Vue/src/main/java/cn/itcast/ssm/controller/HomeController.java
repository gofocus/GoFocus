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
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 2016-11-11 16:39
 */

@Controller
public class HomeController {

    @Autowired
    private ItemsService itemsService;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    @ResponseBody
//    public String home_get(Model model, HttpSession httpSession, ItemsQueryVo itemsQueryVo) throws Exception {
    public List<ItemsCustom> home_get(Model model, HttpSession httpSession, ItemsQueryVo itemsQueryVo) throws Exception {

        List<ItemsCustom> itemList = itemsService.findItemsList(itemsQueryVo);
        model.addAttribute("itemList", itemList);

        Subject subject = SecurityUtils.getSubject();
        ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
        httpSession.setAttribute("activeUser",activeUser);
        model.addAttribute("activeUser", activeUser);

        return itemList;
//        return "index";

    }

    @RequestMapping(value = "/ajaxIndex")
    public String ajax_index(Model model,ItemsQueryVo itemsQueryVo) throws Exception {
        List<ItemsCustom> itemsList = itemsService.findItemsByParam(itemsQueryVo);
        model.addAttribute("itemList", itemsList);
        return "ajaxIndex";
    }

    @RequestMapping(value = "/carouselList")
    @ResponseBody
    public List carouselList() {
//        String[] carouselList = new String[]{};
        List<String> carouselList = new ArrayList<>();
        String baseUrl = "https://picsum.photos/1263/920/?image=";
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            String url = baseUrl + random.nextInt(1000);
            carouselList.add(url);
        }

        return carouselList;
    }





}




