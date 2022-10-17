package dev.com.config;

import dev.com.intercepter.LogAnnotationIntercepter;
import dev.com.intercepter.LoginIntercepter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginIntercepter()).addPathPatterns("/user/*");
        registry.addInterceptor(new LogAnnotationIntercepter()).addPathPatterns("/order/*");

    }
}
