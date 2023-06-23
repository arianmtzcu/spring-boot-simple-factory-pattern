package com.arian.example.demo.service;

import java.math.BigDecimal;
import java.text.MessageFormat;

import org.springframework.stereotype.Component;

@Component
public class GooglePayPaymentService implements PaymentService {

   @Override
   public String pay(final BigDecimal amount) {
      return MessageFormat.format("Successfully paid ${0} to merchant using Google Pay", amount);
   }

}
