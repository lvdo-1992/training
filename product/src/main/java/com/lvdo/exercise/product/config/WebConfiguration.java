package com.lvdo.exercise.product.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 
 * @author lvdo
 *
 */
@Configuration
public class WebConfiguration {
    
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
