package com.ynfinal.finalproject.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// 전역 크로스 오리진 설정
@Configuration
public class CorsConfig implements WebMvcConfigurer {
    public static final String ALLOWED_METHOD_NAMES = "GET,HEAD,POST,PUT,DELETE,TRACE,OPTIONS,PATCH";

    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry
                .addMapping("/**")
                .allowedMethods(ALLOWED_METHOD_NAMES.split(",")); // 어떤 요청에 대해서 허용할지?
//                .allowedOrigins("*")// 어떤 클라이언트를 허용할지
//                .allowedMethods("*") // 어떤 요청 방식을 허용할지
//                .allowedHeaders("*")  // 어떤 요청 헤더를 허용할지
//                .allowCredentials(true) // 쿠키 전달을 허용할 것인지
//                .maxAge(3600) // 캐싱 시간을 설정 , 클라이언트에 저장해 써
        ;
    }

}
