package com.mario.demo.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean commonFilter() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        FilterCommon filter = new FilterCommon();
        registrationBean.setFilter(filter);
        registrationBean.setName("@@");
        registrationBean.setOrder(1);
        registrationBean.addUrlPatterns("/*");
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean FrontFilter() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        FilterCommon filter = new FilterCommon();
        registrationBean.setFilter(filter);
        registrationBean.setName("@@");
        registrationBean.setOrder(2);
        registrationBean.addInitParameter("","/*");
        registrationBean.addUrlPatterns("/*");
        return registrationBean;
    }
}
