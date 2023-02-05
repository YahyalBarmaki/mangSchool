package com.yahya.mangschool.config;

import com.yahya.mangschool.services.JavaDateFacade;
import com.yahya.mangschool.services.impl.JavaDateInstant;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public JavaDateFacade getDate(){
        return new JavaDateInstant();
    }
}
