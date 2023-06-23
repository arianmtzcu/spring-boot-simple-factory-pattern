package com.arian.example.demo.factory;

import com.arian.example.demo.service.PaymentService;
import com.arian.example.demo.model.enums.PaymentMethod;

public interface PaymentFactory {

   PaymentService getInstance(PaymentMethod paymentMethod) throws ClassNotFoundException;

}
