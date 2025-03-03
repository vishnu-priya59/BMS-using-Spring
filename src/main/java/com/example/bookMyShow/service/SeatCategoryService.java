package com.example.bookMyShow.service;

import com.example.bookMyShow.entity.SeatCategory;
import com.example.bookMyShow.repo.SeatCategoryRepo;
import org.springframework.stereotype.Service;

@Service
public class SeatCategoryService {

    private final SeatCategoryRepo seatCategoryRepo;

    public SeatCategoryService(SeatCategoryRepo seatCategoryRepo) {
        this.seatCategoryRepo = seatCategoryRepo;
    }

    public SeatCategory createCategory(int price) {
        SeatCategory seatCategory = new SeatCategory(price);
        return seatCategoryRepo.save(seatCategory);
    }

    public SeatCategory getSeatCategoryById(String categoryId) {
        return seatCategoryRepo.findById(categoryId);
    }
}
