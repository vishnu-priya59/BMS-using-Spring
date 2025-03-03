package com.example.bookMyShow.dto;

import com.example.bookMyShow.entity.PaymentMethod;
import org.springframework.stereotype.Component;

@Component
public class PaymentRequest {
    private PaymentMethod payMethod;
    private int amount;
    private String time;

    public PaymentMethod getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(PaymentMethod payMethod) {
        this.payMethod = payMethod;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
