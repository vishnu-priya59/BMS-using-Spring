package com.example.bookMyShow.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
public class ScreenRequest {
    private String theatreId;
    private String name;
    private int totalSeats;

}
