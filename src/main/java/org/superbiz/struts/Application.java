package org.superbiz.struts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class Application {

    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public FilterRegistrationBean struts2(){
        FilterRegistrationBean frb = new FilterRegistrationBean();
            frb.setFilter(new org.apache.struts2.dispatcher.FilterDispatcher());
            Map<String,String> initParams = new HashMap<String,String>();
                initParams.put("actionPackages","com.lq");
            frb.setInitParameters(initParams);
            frb.addUrlPatterns("/*");
            frb.setOrder(1);
        return frb;
    }

    @Bean
    public FilterRegistrationBean strutsCleanupFilter(){
        FilterRegistrationBean frb = new FilterRegistrationBean();
            frb.setFilter(new org.apache.struts2.dispatcher.ActionContextCleanUp());
            frb.addUrlPatterns("/*");
            frb.setOrder(2);
        return frb;
    }

    @Bean
    public FilterRegistrationBean sitemesh(){
        FilterRegistrationBean frb = new FilterRegistrationBean();
            frb.setFilter(new com.opensymphony.module.sitemesh.filter.PageFilter());
            frb.addUrlPatterns("/*");
            frb.setOrder(2);
        return frb;
    }
}