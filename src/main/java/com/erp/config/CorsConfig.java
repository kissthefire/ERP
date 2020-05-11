package com.erp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * 版本         开发者               创建日期
 * 1.0.0   InetCommunity(^_^)on
 * 防止跨域配置
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
         .allowedOrigins("*")
         .allowCredentials(true)
         .allowedMethods("GET", "POST", "DELETE", "PUT","OPTIONS")
         .maxAge(3600);
         }

         private CorsConfiguration buildConfig() {
             CorsConfiguration corsConfiguration = new CorsConfiguration();
             corsConfiguration.addAllowedOrigin("*"); // 1 设置访问源地址
             corsConfiguration.addAllowedHeader("*"); // 2 设置访问源请求头
             corsConfiguration.addAllowedMethod("*"); // 3 设置访问源请求方法
             return corsConfiguration;
         }

         @Bean
         public CorsFilter corsFilter() {
             UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
             source.registerCorsConfiguration("/**", buildConfig()); // 4 对接口配置跨域设置
             return new CorsFilter(source);
         }
}
