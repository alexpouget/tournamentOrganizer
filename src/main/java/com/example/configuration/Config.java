package com.example.configuration;

import com.example.aspect.LogAspect;
import com.example.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by alex on 06/04/2016.
 */
@Configuration
@EnableAspectJAutoProxy
public class Config {
    @Bean
    public LogAspect LogAspect(){
        return new LogAspect();
    }

}
