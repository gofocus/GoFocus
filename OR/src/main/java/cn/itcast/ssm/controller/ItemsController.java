package cn.itcast.ssm.controller;

import cn.itcast.ssm.po.*;
import cn.itcast.ssm.service.ClassesService;
import cn.itcast.ssm.service.ItemsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * 2016-11-10 15:41
 */

@Controller
@RequestMapping("/items")
public class ItemsController {

    @Autowired
    private ItemsService itemsService;

    @Autowired
    private ClassesService classesService;


    //删除任意个商品
    @RequestMapping(value = "/remove")
    @ResponseBody
    public Integer remove(HttpServletRequest request) throws IOException {
        String[] stringArray = request.getParameterValues("a[]");
        Integer[] integers = new Integer[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
            integers[i] = Integer.parseInt(stringArray[i]);
        }
        itemsService.deleteItems(integers);
        return stringArray.length;
    }



    //商品分类信息
    @RequestMapping("/classInfo")
    @ResponseBody
    public List<Classes> classInfo(Integer id) {
        return classesService.selectById(id);
    }


    //批量修改商品
    @RequestMapping(value = "/editAllItems",method = RequestMethod.GET)
    @RequiresPermissions("item:update")
    public String editItemsAll(Model model, ItemsQueryVo itemsQueryVo) throws Exception {

        List<ItemsCustom> itemsList = itemsService.findItemsList(itemsQueryVo);
        model.addAttribute("itemsList", itemsList);
        return "items/editAllItems";
    }


    @RequestMapping(value = "/editAllItems",method = RequestMethod.POST)
    @RequiresPermissions("item:update")
    @ResponseBody
    public EUDataGridResult editAllItems(Integer page, Integer rows, ItemsQueryVo itemsQueryVo) throws Exception {
        PageHelper.startPage(page, rows);
        List<ItemsCustom> itemsList = itemsService.findItemsByParamResultMap(itemsQueryVo);
//        List<ItemsCustom> itemsList = itemsService.findItemsByParam(itemsQueryVo);
        PageInfo<ItemsCustom> p = new PageInfo<>(itemsList);
        EUDataGridResult<ItemsCustom> itemsCustomEUDataGridResult = new EUDataGridResult<>();
        itemsCustomEUDataGridResult.setRows(itemsList);
        itemsCustomEUDataGridResult.setTotal(p.getTotal());

        return itemsCustomEUDataGridResult;
    }

    //搜索商品
    @RequestMapping(value = "/query_items", method = RequestMethod.POST)
    public String query_items(Model model, ItemsQueryVo itemsQueryVo) throws Exception {
        List<ItemsCustom> itemsList = itemsService.findItemsList(itemsQueryVo);
        model.addAttribute("itemsList", itemsList);
        return "query_index";
    }

    //添加商品
    @RequestMapping(value = "/addItems", method = RequestMethod.POST)
    @RequiresPermissions("item:create")
    @ResponseBody
    public ItemsCustom addItemsPost(MultipartFile piccc, ItemsCustom itemsCustom) throws IOException {
        if (piccc != null) {
            String originnalFileName = piccc.getOriginalFilename();
            if (originnalFileName != null && originnalFileName.length() > 0) {
                String pic_path = "D:\\java\\svn\\ssm_new\\springmvc\\src\\main\\webapp\\WEB-INF\\img\\product\\";
                String newFileName = UUID.randomUUID() + originnalFileName.substring(originnalFileName.lastIndexOf("."));
                File newFile = new File(pic_path + newFileName);
                piccc.transferTo(newFile);
                itemsCustom.setPic(newFileName);
            }
            else itemsCustom.setPic("123.jpg");
        }

        itemsCustom.setCreatetime(new Date());
        itemsService.addItemsAndId(itemsCustom);
        return itemsCustom;

    }

    //ajax异步修改价格
    @RequestMapping("/editPrice")
    @ResponseBody
    public ItemsCustom editPrice(int id, float price) {
        ItemsCustom itemsCustom = itemsService.findItemsById(id);
        itemsCustom.setPrice(price);
        itemsService.updateItems(id, itemsCustom);
        return itemsCustom;
    }


    //获取单个商品的数据，参数为商品的id
    @RequestMapping(value = "/getItemInfo",method = RequestMethod.POST)
    @ResponseBody
    public ItemsCustom getItemInfo(int itemId){
        ItemsCustom itemsCustom = itemsService.findItemsById(itemId);
        return itemsCustom;
    }

    //GET商品数据，参数为商品的id
    @RequestMapping(value = "/editItem/{id}",method = RequestMethod.GET)
    @RequiresPermissions("item:update")
    @ResponseBody
    public ItemsCustom editItem(@PathVariable int id, Model model){
        ItemsCustom itemsCustom = itemsService.findItemsById(id);
        model.addAttribute("itemsCustom", itemsCustom);
//        return "items/editItem";
        return itemsCustom;
    }

    //提交商品修改
    @RequestMapping(value = "/editItem", method = RequestMethod.POST)
    @RequiresPermissions("item:update")
    @ResponseBody
    public ItemsCustom editItem(MultipartFile piccc, ItemsCustom itemsCustom) throws IOException {
        int id = itemsCustom.getId();
        if (piccc!=null) {
            String originnalFileName = piccc.getOriginalFilename();
            if (originnalFileName != null && originnalFileName.length() > 0) {
                String pic_path = "D:\\java\\svn\\ssm_new\\springmvc\\src\\main\\webapp\\WEB-INF\\img\\product\\";
                String newFileName = UUID.randomUUID() + originnalFileName.substring(originnalFileName.lastIndexOf("."));
                File newFile = new File(pic_path + newFileName);
                piccc.transferTo(newFile);
                itemsCustom.setPic(newFileName);
            }
        }
        itemsService.updateItemSelective(id, itemsCustom );
        return itemsCustom;
    }


    //商品详情页面
    @RequestMapping("/product-details/{id}")
    public String product_details(@PathVariable int id, Model model){
        ItemsCustom itemsCustom = itemsService.findItemsById(id);
        model.addAttribute("itemsCustom", itemsCustom);
        return "/items/product-details";
    }


//    @RequestMapping("/upLoadPic")
//    @ResponseBody
//    public String upLoadPic(int id, MultipartFile pic, Model model) throws IOException {
//        ItemsCustom itemsCustom = itemsService.findItemsById(id);
//        String originnalFileName = pic.getOriginalFilename();
//        if (originnalFileName != null && originnalFileName.length() > 0) {
//            String pic_path = "D:\\pic\\";
//            String newFileName = UUID.randomUUID() + originnalFileName.substring(originnalFileName.lastIndexOf("."));
//            File newFile = new File(pic_path + newFileName);
//            pic.transferTo(newFile);
//            itemsCustom.setPic(newFileName);
//        }
//        itemsService.updateItems(id, itemsCustom);
//        model.addAttribute("itemsCustom", itemsCustom);
//        return "items/editItem";
//    }

    @RequestMapping("/editItemsSubmit")
    public String editItemsSubmit(Integer id, ItemsCustom itemsCustom){
        itemsService.updateItems(id, itemsCustom);
        return "success";
    }

    @RequestMapping(value = "/editItemsQuery")
    public String editItemsQueryGet(Model model, ItemsQueryVo itemsQueryVo) throws Exception {
        List<ItemsCustom> itemsList = itemsService.findItemsList(itemsQueryVo);

        model.addAttribute("itemsList", itemsList);

        return "items/editItemsQuery";
    }

//    @RequestMapping(value="/editItemsQuery", method = RequestMethod.POST)
//    public String editItemsQueryPost(ItemsQueryVo itemsQueryVo){{
//
//        List<ItemsCustom> list = itemsQueryVo.getItemsList();
//        for (ItemsCustom items:list
//                ){
//        itemsService.updateItems(items.getId(),items);
//
//        }
//        return "success";
//    }

    @RequestMapping("/editItemsAllSubmit")
    public String editItemsAllSubmit(ItemsQueryVo itemsQueryVo) {
        List<ItemsCustom> list = itemsQueryVo.getItemsList();
        for (ItemsCustom items:list
                ){
        itemsService.updateItems(items.getId(),items);
        }
        return "success";
    }

    @RequestMapping("/updateItemSelective")
    public String updateItemSelective(int id){
        ItemsCustom itemsCustom = itemsService.findItemsById(id);
        return "index";
    }



}
