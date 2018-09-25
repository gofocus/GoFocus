package cn.itcast.ssm.exception;

import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by gofocus on 2017/3/28 13:24.
 */
public class CustomExceptionHandler implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
    //handler就是处理器适配器要执行Handler对象（只有method）

        //CustomException customException = new CustomException();
        CustomException customException = null;
        String msg = null;

        if (e instanceof CustomException){
            customException = (CustomException) e;
        }
        else if (e instanceof UnauthorizedException){
            return new ModelAndView("sysUser/refuse");
        }/*else if(e instanceof InvocationTargetException){
            try {
                throw ((InvocationTargetException) e).getTargetException();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }*/
        else if(e instanceof InvocationTargetException) {
            /*Throwable targetEx = ((InvocationTargetException) e).getTargetException();
            if (targetEx != null) {
                msg = targetEx.getMessage();
            }*/
            e.printStackTrace();
        }
        else {
            customException = new CustomException("未知错误!!");
        }

        String message = customException.getMessage();


        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("message", message);

        modelAndView.setViewName("sysUser/error");

        return modelAndView;

    }


}
