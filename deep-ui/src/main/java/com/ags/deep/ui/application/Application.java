package com.ags.deep.ui.application;

import com.ags.deep.ui.coffee.CoffeeServlet;
import com.ags.deep.ui.thymeleaf.interceptor.ThymeleafLayoutInterceptor;
import com.asual.lesscss.LessServlet;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Main SpringBoot configuration class.
 * Created by Gavalda on 12/13/2014.
 */

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.ags.deep"})
public class Application extends WebMvcConfigurerAdapter {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Value("${servlet.less.cache}")
    private String lessCached;
    @Value("${servlet.coffee.cache}")
    private String coffeeCached;

    @Bean
    public ServletRegistrationBean servletRegistrationLessBean(){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new LessServlet(), "*.less");
        registrationBean.setLoadOnStartup(1);
        registrationBean.setName("LessServlet");
        registrationBean.addInitParameter("cache", lessCached);
        return registrationBean;
    }

    @Bean
    public ServletRegistrationBean servletRegistrationCoffeeBean(){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new CoffeeServlet(), "*.coffee");
        registrationBean.setLoadOnStartup(1);
        registrationBean.setName("CoffeeScript");
        registrationBean.addInitParameter("cache",coffeeCached);
        return registrationBean;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
        registry.addInterceptor(new ThymeleafLayoutInterceptor());
    }
}
