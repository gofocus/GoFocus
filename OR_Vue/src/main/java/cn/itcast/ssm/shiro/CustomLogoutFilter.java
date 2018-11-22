package cn.itcast.ssm.shiro;

import org.apache.shiro.session.SessionException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.LogoutFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @Author: GoFocus
 * @Date: 2018-11-19
 * @Time: 11:07
 * @Description:
 */
public class CustomLogoutFilter extends LogoutFilter {
    private static final Logger log = LoggerFactory.getLogger(LogoutFilter.class);

    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        Subject subject = this.getSubject(request, response);

        try {
            subject.logout();
            subject.getSession(true);
        } catch (SessionException var6) {
            log.debug("Encountered session exception during logout.  This can generally safely be ignored.", var6);
        }

        return false;
    }

}
