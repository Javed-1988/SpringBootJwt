package com.example.springbootweb.configuration;

import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@Slf4j
@PropertySource(value = "classpath:application.properties")
public class PropertySourceConfigureExample {

    @Autowired
    private Environment env;


    public PropertySourceConfigureExample()
    {
       log.info("PropertySourceConfigureExample bean initialized values");


    }
    public void display()
    {
        String p=env.getProperty("spring.datasource.url");
        log.info("values---"+p);
    }
}
