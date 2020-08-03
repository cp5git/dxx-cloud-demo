package com.dxx.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import java.util.Arrays;


/**
 * 允许跨域访问配置
 * @author cp5
 * @date 2020年 08月02日 00:11:08
 */
@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration config = new CorsConfiguration();

        config.setAllowCredentials(true);
        config.setAllowedOrigins(Arrays.asList("*")); //http:www.a.com, http:www.b.com
        config.setAllowedHeaders(Arrays.asList("*"));   //设置传递的请求头
        config.setAllowedMethods(Arrays.asList("*"));   //设置请求的方法，get、post

        config.setMaxAge(300L);     //设置在这个时间段内不再检查跨域

        source.registerCorsConfiguration("/**", config);    //针对所有请求检查跨域
        return new CorsFilter(source);
    }

}
