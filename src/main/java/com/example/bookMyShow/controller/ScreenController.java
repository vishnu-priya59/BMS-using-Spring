package com.example.bookMyShow.controller;

import com.example.bookMyShow.dto.ScreenRequest;
import com.example.bookMyShow.entity.Screen;
import com.example.bookMyShow.service.ScreenService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Screen")
public class ScreenController {

    private final ScreenService screenService;

    public ScreenController(ScreenService screenService) {
        this.screenService = screenService;
    }

    @PostMapping("/create")
    public Screen createScreen(@RequestBody ScreenRequest screenRequest) throws Exception {
        return screenService.createScreen(screenRequest.getTheatreId(),screenRequest.getName(),screenRequest.getTotalSeats());
    }


    @GetMapping("/{screenId}")
    public Screen getScreenById(@PathVariable String screenId) throws Exception{
        return screenService.getScreenById(screenId);
    }
}
