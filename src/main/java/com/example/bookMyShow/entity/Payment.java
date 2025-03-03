package com.example.bookMyShow.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Random;

@Document(collection = "Payment")
public class Payment {

    @Id
    private String id; // pk
    private PaymentMethod payMethod;
    private int amount;
    private String time;
    private PaymentStatus status;

    public Payment(PaymentMethod payMethod, int amount, String time) {
        this.payMethod = payMethod;
        this.amount = amount;
        this.time = time;
        this.status = generateRandomStatus();
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public PaymentStatus getStatus() {
        return status;
    }

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

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

    private PaymentStatus generateRandomStatus() {
        Random random = new Random();
        return random.nextInt(100) < 60 ? PaymentStatus.SUCCESS : PaymentStatus.FAILED;
    }
}

