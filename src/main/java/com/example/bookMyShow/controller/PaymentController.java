package com.example.bookMyShow.controller;

import com.example.bookMyShow.dto.PaymentRequest;
import com.example.bookMyShow.entity.Payment;
import com.example.bookMyShow.service.PaymentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/create")
    public Payment createPayment(@RequestBody PaymentRequest paymentRequest){
        return paymentService.createPayment(paymentRequest.getPayMethod(), paymentRequest.getAmount(), paymentRequest.getTime());
    }

}
