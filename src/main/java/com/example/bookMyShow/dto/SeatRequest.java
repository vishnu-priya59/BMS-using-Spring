package com.example.bookMyShow.dto;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Component
public class SeatRequest {
    String screenId;
    String categoryId;

    public String getScreenId() {
        return screenId;
    }

    public void setScreenId(String screenId) {
        this.screenId = screenId;
    }

    public String getCategoryId() {
        return categoryId;
    }

}
