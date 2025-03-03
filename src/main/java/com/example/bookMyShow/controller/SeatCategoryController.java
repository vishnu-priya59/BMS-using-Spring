package com.example.bookMyShow.controller;

import com.example.bookMyShow.entity.SeatCategory;
import com.example.bookMyShow.service.SeatCategoryService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/SeatCategory")
public class SeatCategoryController {

    private final SeatCategoryService seatCategoryService;

    public SeatCategoryController(SeatCategoryService seatCategoryService) {
        this.seatCategoryService = seatCategoryService;
    }

    @PostMapping("/create/{price}")
    public SeatCategory createCategory(@PathVariable int price){
        return seatCategoryService.createCategory(price);
    }

    @GetMapping("/getSeatCategoryById/{categoryId}")
    public SeatCategory getSeatCategoryById(@PathVariable String categoryId){
        return seatCategoryService.getSeatCategoryById(categoryId);
    }
}
