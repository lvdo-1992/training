package com.lvdo.exercise.product.config;

import org.modelmapper.config.Configuration;
import org.springframework.stereotype.Component;

import com.github.rozidan.springboot.modelmapper.ConfigurationConfigurer;

/**
 * Global model mapper config
 * 
 * @author lvdo
 *
 */
@Component
public class ModelMapperConfig extends ConfigurationConfigurer {

    @Override
    public void configure(Configuration configuration) {
        configuration.setSkipNullEnabled(true).setAmbiguityIgnored(true);
    }

}
