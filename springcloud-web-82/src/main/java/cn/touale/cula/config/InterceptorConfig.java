package cn.touale.cula.config;

import cn.touale.cula.interceptor.WebInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Touale
 * @description InterceptorConfig
 * @date 2021/12/30 23:38
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        InterceptorRegistration registration = registry.addInterceptor(new WebInterceptor());
        registration.addPathPatterns("/**");                      //所有路径都被拦截
        registration.excludePathPatterns(                         //添加不拦截路径
                "/login",
                "/doLogin",
                "/index",
                "/js/*.js",
                "/CSS/*.css",
                "/Images/*.gif",
                "/Images/*.jpg",
                "/images/*.gif",
                "/",
                "/index-elements/**",
                "/news_read",
                "/favicon.ico",
                "/util/do_add_comment"
        );
    }
}
