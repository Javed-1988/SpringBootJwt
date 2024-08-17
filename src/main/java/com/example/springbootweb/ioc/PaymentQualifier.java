package com.example.springbootweb.ioc;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class PaymentQualifier implements  AdminQualifier{
}
