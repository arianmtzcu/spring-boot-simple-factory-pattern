package com.arian.example.demo.factory;

import static com.arian.example.demo.model.enums.PaymentMethod.CREDIT_CARD;
import static com.arian.example.demo.model.enums.PaymentMethod.GOOGLE_PAY;
import static com.arian.example.demo.model.enums.PaymentMethod.PAYPAL;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.arian.example.demo.service.CreditCardPaymentService;
import com.arian.example.demo.service.GooglePayPaymentService;
import com.arian.example.demo.service.PayPalPaymentService;
import com.arian.example.demo.service.PaymentService;
import com.arian.example.demo.model.enums.PaymentMethod;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PaymentFactoryImpl implements PaymentFactory {

   private static final Map<PaymentMethod, PaymentService> HANDLER = new HashMap<>();

   private final CreditCardPaymentService creditCardPaymentService;

   private final GooglePayPaymentService googlePayPaymentService;

   private final PayPalPaymentService payPalPaymentService;

   @PostConstruct
   private void init() {
      HANDLER.put(CREDIT_CARD, creditCardPaymentService);
      HANDLER.put(GOOGLE_PAY, googlePayPaymentService);
      HANDLER.put(PAYPAL, payPalPaymentService);
   }

   public PaymentService getInstance(final PaymentMethod paymentMethod) throws ClassNotFoundException {
      return Optional.ofNullable(HANDLER.get(paymentMethod))
                     .orElseThrow(() -> new ClassNotFoundException("Error creating instance: Payment Method not found."));
   }

}
