package cn.acey.mvc2cleanarch.adapter.inbound.rest.resources.handlers;

import cn.acey.mvc2cleanarch.adapter.inbound.rest.resources.auth.AuthResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new AuthResolver());
    }
}