package cn.itcast.ssm.controller;

import cn.itcast.ssm.po.BuyerCart;
import cn.itcast.ssm.po.BuyerItem;
import cn.itcast.ssm.po.ItemsCustom;
import cn.itcast.ssm.service.ItemsService;
import cn.itcast.ssm.utils.Constants;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private ItemsService itemsService;

    //购物车页面
    @RequestMapping("/")
    public String cart(HttpServletRequest httpServletRequest, Model model) throws IOException {
        ObjectMapper om = new ObjectMapper();
        om.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        BuyerCart buyerCart = null;
        Cookie[] cookies = httpServletRequest.getCookies();
        if (null != cookies && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                if (Constants.BUYER_CART.equals(cookie.getName())) {
                    buyerCart = om.readValue(URLDecoder.decode(cookie.getValue(), "utf-8"), BuyerCart.class);
                    break;
                }
            }
        }
        if (null != buyerCart) {
            model.addAttribute("buyerCart", buyerCart.getItems());
            model.addAttribute("cartSize", buyerCart.getItems().size());
            model.addAttribute("orderTotal", buyerCart.getOrder_total());
        } else model.addAttribute("buyerCart", null);

        return "/cart/cart";
    }

    //微型购物车
    @RequestMapping("/microCart")
    public String microCart(HttpServletRequest httpServletRequest, Model model) throws IOException {
        ObjectMapper om = new ObjectMapper();
        om.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        BuyerCart buyerCart = null;
        Cookie[] cookies = httpServletRequest.getCookies();
        if (null != cookies && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                if (Constants.BUYER_CART.equals(cookie.getName())) {
                    buyerCart = om.readValue(URLDecoder.decode(cookie.getValue(), "utf-8"), BuyerCart.class);
                    break;
                }
            }
        }
        List<BuyerItem> items;
        if (buyerCart != null) {
            items = buyerCart.getItems();
            model.addAttribute("buyerCart", items);
            model.addAttribute("cartSize", items.size());
        }
        else model.addAttribute("buyerCart", null);



        return "/cart/microCart";

    }

    //购物车cart_dataGrid
    @RequestMapping("/cart_dataGrid")
    @ResponseBody
    public List<BuyerItem> cart_dataGrid(HttpServletRequest httpServletRequest, Model model) throws IOException {
//    public String cart(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Model model) throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper om = new ObjectMapper();
        om.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        BuyerCart buyerCart = null;
        Cookie[] cookies = httpServletRequest.getCookies();
        if (null != cookies && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                if (Constants.BUYER_CART.equals(cookie.getName())) {
                    buyerCart = om.readValue(URLDecoder.decode(cookie.getValue(), "utf-8"), BuyerCart.class);
                    break;
                }
            }
        }
        if (null != buyerCart) return buyerCart.getItems();
        else return null;
    }


    //删除购物车中的商品
    @RequestMapping("/remove")
    @ResponseBody
    public void cart_remove(Integer itemId, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        ObjectMapper om = new ObjectMapper();
        om.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        BuyerCart buyerCart = null;
        Cookie[] cookies = httpServletRequest.getCookies();
        if (null != cookies && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                if (Constants.BUYER_CART.equals(cookie.getName())) {
                    buyerCart = om.readValue(URLDecoder.decode(cookie.getValue(), "utf-8"), BuyerCart.class);
                    break;
                }
            }
        }

        if (itemId != null) buyerCart.remove_item(itemId);
        Writer w = new StringWriter();
        om.writeValue(w, buyerCart);
        Cookie cookie = new Cookie(Constants.BUYER_CART, URLEncoder.encode(w.toString(), "utf-8"));
        cookie.setPath("/");
        cookie.setMaxAge(-1);
        httpServletResponse.addCookie(cookie);

//        return "redirect:/cart/";

    }

    //购物车添加商品
    @RequestMapping("/addItems")
//    @ResponseBody
    public void cart_addItems(Integer AbQuantity, Integer itemId, Integer quantity, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        ObjectMapper om = new ObjectMapper();
        om.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        BuyerCart buyerCart = null;
        Cookie[] cookies = httpServletRequest.getCookies();
        if (null != cookies && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                if (Constants.BUYER_CART.equals(cookie.getName())) {
                    buyerCart = om.readValue(URLDecoder.decode(cookie.getValue(), "utf-8"), BuyerCart.class);
                    break;
                }
            }
        }

        //cookie中没有购物车，则创建购物车对象
        if (null == buyerCart) {
            buyerCart = new BuyerCart();
        }

        //将该商品加入到购物车
        if (itemId != null && (quantity != null) || AbQuantity != null) {
            //ItemsCustom item = itemsService.findItemsById(itemId);
            //不能直接找到itemsCustom放在cookie中
            //因为商品相关的信息会随时发生变化，不能将查询到的商品信息放进BuyerCart，要在前台通过ajax的方式实时获取数据库中Item相关的信息。

            // 但同时也要创建BuyerItem对象来存储Item的ID和quantity，并将BuyerItem对象放进BuyerCart，再把BuyerCart放进cookie（quantity根据用户需求改变大小）
            ItemsCustom itemsCustom = new ItemsCustom();

            //ItemsCustom只存储Item的id（Item的id一般来说是不会变的）
            if (itemId != null)
                itemsCustom.setId(itemId);
            BuyerItem new_item = new BuyerItem();

            if (quantity != null) {
                new_item.setQuantity(quantity);
                new_item.setItemsCustom(itemsCustom);
                buyerCart.addItems(new_item, quantity);
            }
            if (AbQuantity != null) {
                new_item.setQuantity(AbQuantity);
                new_item.setItemsCustom(itemsCustom);
                buyerCart.addItems(new_item, AbQuantity);
            }
        }

        List<BuyerItem> items = buyerCart.getItems();
        float order_total = 0f;
        for (BuyerItem item : items) {
            item.setItemsCustom(itemsService.findItemsById(item.getItemsCustom().getId()));
            item.setSubTotal();
            order_total += item.getSubTotal();
        }
        buyerCart.setOrder_total(order_total);


 /*       Collections.sort(items, new Comparator<BuyerItem>() {
            @Override
            public int compare(BuyerItem o1, BuyerItem o2) {
                return -1;
            }
        });
*/
        //未登录
        //4, 保存购物车到Cookie中
        //将对象转换成json格式
        Writer w = new StringWriter();
        om.writeValue(w, buyerCart);
//        Cookie cookie = new Cookie("BUYER_CART", w.toString());
        Cookie cookie = new Cookie(Constants.BUYER_CART, URLEncoder.encode(w.toString(), "utf-8"));
        //设置path是可以共享cookie
        cookie.setPath("/");
        //设置Cookie过期时间: -1 表示关闭浏览器失效  0: 立即失效  >0: 单位是秒, 多少秒后失效
        cookie.setMaxAge(-1);
//        cookie.setMaxAge(24 * 60 * 60);
        //5,Cookie写回浏览器
        httpServletResponse.addCookie(cookie);

    }



    @RequestMapping("/buyerCart")
    @ResponseBody
    public BuyerCart buyerCart(HttpServletRequest httpServletRequest) throws IOException {
        ObjectMapper om = new ObjectMapper();
        om.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        BuyerCart buyerCart = null;
        Cookie[] cookies = httpServletRequest.getCookies();
        if (null != cookies && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                if (Constants.BUYER_CART.equals(cookie.getName())) {
                    buyerCart = om.readValue(URLDecoder.decode(cookie.getValue(), "utf-8"), BuyerCart.class);
                    break;
                }
            }
        }

        return buyerCart;
    }


}
