package com.example.springbootweb.controller;

import com.example.springbootweb.service.BeanExample;
import com.example.springbootweb.service.QualifierExample;
import com.example.springbootweb.service.Studentservice;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BeanControllerExample {


    //Field injection
    //Final is not allowed in field injection
   // @Autowired
     private final QualifierExample qualifierExample;


     /*
     Setter Injection
     Final is not allowed in Setter injection
         @Autowired
         public void setBeanExample(BeanExample beanExample) {
             this.beanExample = beanExample;
         }

    }
     */
    //Constructor Injection
    @Autowired
    public BeanControllerExample(QualifierExample qualifierExample) {
        this.qualifierExample = qualifierExample;

    }


    @PostConstruct
    public void init()
    {
        System.out.println("Hashcode of BeanControllerExample--"+this.hashCode()+" Hashcode of beanExample is------"+qualifierExample.hashCode());
    }


}
