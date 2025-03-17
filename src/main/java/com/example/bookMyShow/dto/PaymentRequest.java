package com.example.bookMyShow.dto;

import com.example.bookMyShow.entity.PaymentMethod;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
public class PaymentRequest {
    private PaymentMethod payMethod;
    private int amount;
    private String time;

}
