package com.example.springbootweb.ioc;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class User {
    Payment payment;

    @Autowired
    public User(Payment payment) {
        this.payment = payment;
    }
//@Autowired
//public void setOrder(Order order) {
//    this.order = order;
//}

    @PostConstruct
    public void init()
    {
        System.out.println("User bean hashcode---"+this.hashCode()+" Payment bean hashcode in user bean-"+payment.hashCode());
    }
}
