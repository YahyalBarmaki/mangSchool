package com.yahya.mangschool.config;

import com.yahya.mangschool.services.JavaDateFacade;
import com.yahya.mangschool.services.impl.JavaDateInstant;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition
@Configuration
public class BeanConfig {

    @Bean
    public JavaDateFacade getDate(){
        return new JavaDateInstant();
    }
    @Bean
    public OpenAPI baseApi(){
        return new OpenAPI().info(new Info()
                .title("Manag-School doc").version("1.0.0").description("Mang-School doc"));
    }
}
