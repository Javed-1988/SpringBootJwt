package com.example.springbootweb.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource(value = "classpath:application.properties")
public class PropertySourceConfigureExample {

    @Autowired
    private Environment env;


    public PropertySourceConfigureExample()
    {
        System.out.println("PropertySourceConfigureExample bean initialized values");


    }
    public void display()
    {
        String p=env.getProperty("spring.datasource.url");
        System.out.println("values---"+p);
    }
}
