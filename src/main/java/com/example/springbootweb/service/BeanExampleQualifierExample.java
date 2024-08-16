package com.example.springbootweb.service;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class BeanExampleQualifierExample implements  QualifierExample {


  public BeanExampleQualifierExample()
  {
      System.out.println("BeanExampleQualifierExample is initialized");
  }

    @PostConstruct
    public void init()
    {
        System.out.println("hashcode of BeanExampleQualifierExample--"+this.hashCode());
    }
}
