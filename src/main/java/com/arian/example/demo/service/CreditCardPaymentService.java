package com.arian.example.demo.service;

import java.math.BigDecimal;
import java.text.MessageFormat;

import org.springframework.stereotype.Component;

@Component
public class CreditCardPaymentService implements PaymentService {

   @Override
   public String pay(final BigDecimal amount) {
      return MessageFormat.format("Successfully paid ${0} to merchant using a Credit Card", amount);
   }

}
