package club.futurer.community.configurer;

import com.sun.xml.internal.bind.v2.TODO;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Spring Boot 2.0实现对Interceptor的配置
 */
@Configuration
public class WebAppInterceptorConfigurer implements WebMvcConfigurer{

//    @Autowired
//    private AccessInterceptor accessInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        TODO
//        registry.addInterceptor(accessInterceptor).addPathPatterns("/**");
    }
}
