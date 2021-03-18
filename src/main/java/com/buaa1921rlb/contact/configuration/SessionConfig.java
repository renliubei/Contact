package com.buaa1921rlb.contact.configuration;

import com.buaa1921rlb.contact.interceptor.UserSessionInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SessionConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new UserSessionInterceptor())
                .addPathPatterns("/api/user/**")
                .addPathPatterns("/api/file/**")
                .excludePathPatterns("/api/user/login");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("/api/user/login");
        registry.addViewController("/api/user/**").setViewName("/api/user/login");
    }
}
