package onlineShop.app.onlineShop.confige;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Map;
import java.util.Set;

@Configuration
public class JwtFilterConfig {

    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    @Bean
   public FilterRegistrationBean filterRegistration(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(jwtRequestFilter);
        filterRegistrationBean.addUrlPatterns("/api/*");
        filterRegistrationBean.setName("jwtFilter");
        filterRegistrationBean.setOrder(1);
        return filterRegistrationBean;
    }

}
