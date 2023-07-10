package com.da.common;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
    	//로그인이 필요한 urlMapping
    	List<String> url = Arrays.asList(new String[]{"/deal/bidding","/artist/artistDetail","/deal/workDetail",
    			"/myPage/myWork","/myPage/myCollection","/myPage/myWorkList","/myPage/mMyPage","/myPage/myWorkListReg","/myPage/collection_reg","/myPage/information","/deal/soldoutDetail"});
    	
        registry.addInterceptor(new LoginInterceptor())
        		.addPathPatterns(url);
        
        
    }
}