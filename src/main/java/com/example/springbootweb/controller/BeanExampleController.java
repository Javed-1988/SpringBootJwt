package com.example.springbootweb.controller;

import com.example.springbootweb.service.BeanExample;
import com.example.springbootweb.service.QualifierExample;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class BeanExampleController {

    //@Autowired
    QualifierExample qualifierExample;

    @Autowired
    public void setBeanExample(QualifierExample qualifierExample) {
        this.qualifierExample = qualifierExample;
    }

    public BeanExampleController()
    {
        System.out.println("BeanExampleController bean is initialized");
    }

    @PostConstruct
    public void init()
    {
        System.out.println("hashcode of Bean Student Controller Bean--"+this.hashCode()+" Bean Example hashcode---"+qualifierExample.hashCode());
    }
}
