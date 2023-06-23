package com.arian.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arian.example.demo.model.dto.PaymentDto;
import com.arian.example.demo.factory.PaymentFactory;
import com.arian.example.demo.service.PaymentService;

@RestController
@RequestMapping(path = "/api/payment")
public class PaymentController {

   private final PaymentFactory paymentFactory;

   @Autowired
   public PaymentController(PaymentFactory paymentFactory) {
      this.paymentFactory = paymentFactory;
   }

   @PostMapping(path = "/make")
   public ResponseEntity<String> pay(@RequestBody final PaymentDto paymentDto) {
      try {
         final PaymentService paymentService = paymentFactory.getInstance(paymentDto.getPaymentMethod());
         return new ResponseEntity<>(paymentService.pay(paymentDto.getAmount()), HttpStatus.OK);
      } catch (ClassNotFoundException e) {
         return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
      }
   }

}
