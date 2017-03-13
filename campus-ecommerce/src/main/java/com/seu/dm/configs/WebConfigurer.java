package com.seu.dm.configs;

import com.seu.dm.interceptors.PermissionsInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Greeting on 2017/3/9.
 * 网站的java类方式的配置
 */
@Configuration
public class WebConfigurer extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry interceptorRegistry) {
        interceptorRegistry.addInterceptor(new PermissionsInterceptor()).addPathPatterns("/**");
        super.addInterceptors(interceptorRegistry);
    }


}
