package onlineShop.app.onlineShop.confige;

import onlineShop.app.onlineShop.helper.exception.JwtTokenException;
import onlineShop.app.onlineShop.helper.uimodels.people.UserVm;
import onlineShop.app.onlineShop.services.people.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Component
public class JwtRequestFilter implements Filter {

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @Autowired
    UserService userService;


    private List<String> excludeUrls;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
        excludeUrls = new ArrayList<>();
        excludeUrls.add("/api/user/login");
    }



    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        try {
            String url = ((HttpServletRequest) servletRequest).getRequestURI().toLowerCase();
            if (excludeUrls.stream().anyMatch(x->url.equals(x.toLowerCase()))){
                filterChain.doFilter(servletRequest,servletResponse);
                return;
            }


            String requestTokenHeader = ((HttpServletRequest) servletRequest).getHeader("Authorization");
            if (requestTokenHeader == null || !requestTokenHeader.startsWith("Bearer "))
                throw new JwtTokenException("request token header does not set");


            String token = requestTokenHeader.substring(7);
            String username = jwtTokenUtil.getUsernameFromToken(token);
            if (username == null)
                throw new JwtTokenException("username can not resolve");

            UserVm userVm = new UserVm(userService.getByUsername(username));
            if (!jwtTokenUtil.validateToken(token, userVm))
                throw new JwtTokenException("invalid token");

            filterChain.doFilter(servletRequest, servletResponse);

        } catch (JwtTokenException ex) {
            ((HttpServletResponseWrapper) servletResponse).sendError(HttpServletResponse.SC_UNAUTHORIZED, "unauthorized");
        } catch (Exception ex) {
            ((HttpServletResponseWrapper) servletResponse).sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }
}

