package com.example.bookMyShow.service;

import com.example.bookMyShow.entity.Payment;
import com.example.bookMyShow.entity.PaymentMethod;
import com.example.bookMyShow.repo.PaymentRepo;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private final PaymentRepo paymentRepo;

    public PaymentService(PaymentRepo paymentRepo) {
        this.paymentRepo = paymentRepo;
    }


    public Payment createPayment(PaymentMethod payMethod, int amount, String time) {
        Payment payment = new Payment(payMethod, amount, time);
        paymentRepo.save(payment);
        return payment;
    }

}
