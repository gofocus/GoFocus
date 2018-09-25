package cn.itcast.ssm.interceptor;

import cn.itcast.ssm.po.ActiveUser;
import cn.itcast.ssm.utils.ResourcesUtil;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by gofocus on 2017/3/24.
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {

        //判断是否是公开地址，如果是则放行
        String url = request.getRequestURI();
        List<String> openURLs = ResourcesUtil.getkeyList("openURL");
        for (String openURL:
             openURLs) {
            if (url.contains(openURL)||url.equals("/")){
                return true;
            }
        }

        //判断session是否存在，如果存在则放行
        HttpSession session = request.getSession();
        ActiveUser activeUser = (ActiveUser) session.getAttribute("activeUser");
        if (activeUser != null){
            return true;
        }

        //跳转到登录页面
        request.getRequestDispatcher("/user/login").forward(request,response);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
