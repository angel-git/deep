package com.ags.deep.ui.application;

import com.ags.deep.ui.coffee.CoffeeServlet;
import com.asual.lesscss.LessServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Gavalda on 12/13/2014.
 */

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.ags.deep"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Bean
    public ServletRegistrationBean servletRegistrationLessBean(){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new LessServlet(), "*.less");
        registrationBean.setLoadOnStartup(1);
        registrationBean.setName("LessServlet");
        return registrationBean;
    }

    @Bean
    public ServletRegistrationBean servletRegistrationCoffeeBean(){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new CoffeeServlet(), "*.coffee");
        registrationBean.setLoadOnStartup(1);
        registrationBean.setName("CoffeeScript");
        return registrationBean;
    }



}
