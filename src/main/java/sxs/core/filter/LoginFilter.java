package sxs.core.filter;

import com.sun.deploy.net.HttpResponse;
import org.springframework.context.ApplicationContext;
import sxs.core.service.hrm.UserService;
import sxs.core.util.hrm.ApplicationUtil;
import sxs.core.vo.hrm.UserVo;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Author: shang
 * Create Data: 2020/3/22/022
 */
@WebFilter(filterName = "LoginFilter",urlPatterns = "/page/*")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession();
        String []login_formate = {"loginForm"};
        String currentPath = request.getRequestURI();
        boolean flag = true;
        for(String s:login_formate){
            if(currentPath.endsWith(s)){
                chain.doFilter(request,response);
                flag = false;
            }
        }
        if (flag){
            if (session.getAttribute("login_user") != null){
                chain.doFilter(request, response);
            } else {
                response.sendRedirect("/page/loginForm");
            }
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
