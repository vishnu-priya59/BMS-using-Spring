package com.example.bookMyShow.dto;

import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Getter
@Component
public class SeatRequest {
    String screenId;
    String categoryId;

    public void setScreenId(String screenId) {
        this.screenId = screenId;
    }

}
