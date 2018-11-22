package cn.itcast.ssm.shiro;

import cn.itcast.ssm.controller.UserController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Author: GoFocus
 * @Date: 2018-11-19
 * @Time: 10:51
 * @Description:
 */
public class CustomFormAuthenticationFilter extends FormAuthenticationFilter {
    private static final Logger logger = LogManager.getLogger(UserController.class.getName());

    @Override
    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response) throws Exception {
        return false;
    }


    //重写方法校验验证码
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        //将ServletRequest转换为HttpServletRequest
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        //获取session
        HttpSession session = httpServletRequest.getSession();

        //后台生成的验证码
        String _code = (String)session.getAttribute("_code");
        //用户输入的验证码
        String captcha = httpServletRequest.getParameter("captcha");

        //校验失败，将错误信息设置到request的shiroLoginFailure中
        if (!captcha.equals(_code)){
            httpServletRequest.setAttribute("shiroLoginFailure","captchaException");
            //拒绝访问
            return true;
        }

        //验证码校验成功，继续执行默认的认证步骤
        return super.onAccessDenied(request, response);
    }
}
