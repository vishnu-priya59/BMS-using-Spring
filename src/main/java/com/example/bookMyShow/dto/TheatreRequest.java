package com.example.bookMyShow.dto;


import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
public class TheatreRequest {

    private String name;
    private String address;

}
