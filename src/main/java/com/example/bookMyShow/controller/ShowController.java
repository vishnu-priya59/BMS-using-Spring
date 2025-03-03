package com.example.bookMyShow.controller;

import com.example.bookMyShow.dto.ShowRequest;
import com.example.bookMyShow.entity.Show;
import com.example.bookMyShow.service.ShowService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/show")
public class ShowController {
    private final ShowService showService;

    public ShowController(ShowService showService) {
        this.showService = showService;
    }

    @PostMapping("/create")
    public Show createShow (@RequestBody ShowRequest showRequest) throws Exception {
        return showService.createShow(showRequest.getMovieId(), showRequest.getScreenId(), showRequest.getShowTime());
    }


    @GetMapping("/getShowById/{showId}")
    public Show getShowById(@PathVariable String showId){
        return showService.getShowById(showId);
    }

    @GetMapping("/getShowsByScreenId/{screenId}")
    public List<Show> getShowsByScreenId(@PathVariable String screenId){
        return showService.getShowsByScreenId(screenId);
    }
}
