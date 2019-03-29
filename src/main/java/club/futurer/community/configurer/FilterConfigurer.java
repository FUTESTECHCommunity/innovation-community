package club.futurer.community.configurer;

import club.futurer.community.filter.CorsFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

/**
 * 不需要显示配置，只要实现filter接口，配置@Component注解就可以
 * Created by ZYC on 2017/12/19.
 */
//@Configuration
public class FilterConfigurer {

    @Autowired
    private CorsFilter corsFilter;

    @Bean
    public FilterRegistrationBean filterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(corsFilter);
        registration.addUrlPatterns("/*");
        registration.setName("corsFilter");
        return registration;
    }
}
