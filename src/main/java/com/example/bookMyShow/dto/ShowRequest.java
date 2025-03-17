package com.example.bookMyShow.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
public class ShowRequest {
    private String movieId;
    private String screenId;
    private String showTime;

}
