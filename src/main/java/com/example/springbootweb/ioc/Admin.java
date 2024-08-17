package com.example.springbootweb.ioc;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Admin {

    //Field Injection can not use final
    //@Autowired
    private final Payment payment;
    private final AdminQualifier adminQualifier;

    //Setter Injection can not use final
//    @Autowired
//    public void setOrder(Order order) {
//        this.order = order;
//    }

   // Constructor Injection
    // Inject prototype bean into singleton bean we use @Lookup annotations
    @Autowired
    public Admin(Payment payment,AdminQualifier adminQualifier) {
        this.payment = payment;
        this.adminQualifier=adminQualifier;
    }

    @PostConstruct
    public void init()
    {
        System.out.println("Admin bean hashcode---"+this.hashCode()+" Payment bean hashcode in Admin bean-"+payment.hashCode());
    }
}
