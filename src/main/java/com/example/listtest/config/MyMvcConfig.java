package com.example.listtest.config;

import com.example.listtest.component.AdminLoginHandlerInterceptor;
import com.example.listtest.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//使用WebMvcConfigurerAdapter可以扩展springmvc的功能
@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //super.addViewControllers(registry);
        //浏览器发送/atguigu请求来到success页面
        registry.addViewController("/atguigu").setViewName("success");
    }

    //所有的WebMvcConfigurerAdapter组件都会一起起作用
    //将组件注册在容器中
    @Bean
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter() {
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("main");
                registry.addViewController("/login.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("main");
                registry.addViewController("/about.html").setViewName("about");
                registry.addViewController("/contact.html").setViewName("contact");
                registry.addViewController("/gallery.html").setViewName("gallery");
                registry.addViewController("/services.html").setViewName("services");
                registry.addViewController("/register.html").setViewName("register");
                registry.addViewController("/admin/404.html").setViewName("admin/404");
                registry.addViewController("/admin/userselect.html").setViewName("admin/userselect");
                registry.addViewController("/admin/userupdate.html").setViewName("admin/userupdate");
                registry.addViewController("/admin/petselect.html").setViewName("admin/petselect");
                registry.addViewController("/admin/petupdate.html").setViewName("admin/petupdate");
                registry.addViewController("/admin/appselect.html").setViewName("admin/appselect");
                registry.addViewController("/admin/appupdate.html").setViewName("admin/appupdate");
                registry.addViewController("/admin/serselect.html").setViewName("admin/serselect");
                registry.addViewController("/admin/serupdate.html").setViewName("admin/serupdate");
                registry.addViewController("/admin/serupdate.html").setViewName("admin/serupdate");
                registry.addViewController("/admin/conselect.html").setViewName("admin/conselect");
                registry.addViewController("/admin/wanselect.html").setViewName("admin/wanselect");
                registry.addViewController("/admin/wanupdate.html").setViewName("admin/wanupdate");
                registry.addViewController("/admin/orderselect.html").setViewName("admin/orderselect");
                registry.addViewController("/admin/orderupdate.html").setViewName("admin/orderupdate");
                registry.addViewController("/admin/icons.html").setViewName("admin/icons");
                registry.addViewController("/admin/index.html").setViewName("admin/index");
                registry.addViewController("/admin/map.html").setViewName("admin/map");
                registry.addViewController("/admin/profile.html").setViewName("admin/profile");
                registry.addViewController("/admin/user.html").setViewName("admin/user");
                registry.addViewController("/admin/pet.html").setViewName("admin/pet");
                registry.addViewController("/admin/adopt.html").setViewName("admin/adopt");
                registry.addViewController("/admin/appliance.html").setViewName("admin/appliance");
                registry.addViewController("/admin/service.html").setViewName("admin/service");
                registry.addViewController("/admin/consume.html").setViewName("admin/consume");
                registry.addViewController("/admin/wandering.html").setViewName("admin/wandering");
                registry.addViewController("/admin/order.html").setViewName("admin/order");
                registry.addViewController("/reserve/bath.html").setViewName("reserve/bath");




//                registry.addViewController("/admin/login.html").setViewName("admin/login");
            }
            //注册拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new AdminLoginHandlerInterceptor()).addPathPatterns("/admin/index.html")
                        .excludePathPatterns("/login.html", "/login","/main.html","/register.html");
            }

        };
        return adapter;
    }

    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleResolver();
    }
}
