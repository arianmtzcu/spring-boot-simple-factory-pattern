package com.arian.example.demo.model.dto;

import java.math.BigDecimal;

import com.arian.example.demo.model.enums.PaymentMethod;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaymentDto {

   private BigDecimal amount;

   private PaymentMethod paymentMethod;

}
