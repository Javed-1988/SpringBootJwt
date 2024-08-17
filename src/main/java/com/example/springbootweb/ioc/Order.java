package com.example.springbootweb.ioc;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Order {


//    Payment payment;
//    //Circular Dependency issue when use constructor injection use Lazy to overcome this
//    @Autowired
//    @Lazy
//    public Order(Payment payment) {
//        this.payment = payment;
//    }


    @PostConstruct
    public void init()
    {
        System.out.println("Order bean hashcode---"+this.hashCode());
    }

}
