package com.example.springbootweb.service;

import com.example.springbootweb.controller.BeanControllerExample;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")

public class BeanExample implements  QualifierExample{

    //BeanControllerExample beanControllerExample;

    //To avoid circular dependency injection use Lazy
    //In constructor injection BeanExample is dependent on BeanControllerExample and vice versa
//    @Lazy
//    public BeanExample(BeanControllerExample beanControllerExample) {
//        this.beanControllerExample = beanControllerExample;
//    }
    //    public BeanExample()
//    {
//        System.out.println("Bean Example Bean initialized");
//    }

    @PostConstruct
    public void init()
    {
        System.out.println("hashcode of Bean Example--"+this.hashCode());
    }
}
