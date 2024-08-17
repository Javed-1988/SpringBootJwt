package com.example.springbootweb.ioc;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Payment {

    Order order;
    @Autowired
    public Payment(Order order) {
        this.order = order;
    }

    @PostConstruct
    public void init()
    {
        System.out.println("Payment bean hashcode---"+this.hashCode()+" Order bean hashcode in Payment bean-"+order.hashCode());
    }
}
