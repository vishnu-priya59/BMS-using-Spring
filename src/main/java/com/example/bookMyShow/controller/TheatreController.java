package com.example.bookMyShow.controller;

import com.example.bookMyShow.dto.TheatreRequest;
import com.example.bookMyShow.entity.Theatre;
import com.example.bookMyShow.service.TheatreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/theatre")
public class TheatreController {
    private final TheatreService theatreService;

    public TheatreController(TheatreService theatreService) {
        this.theatreService = theatreService;
    }

    @PostMapping("/create")
    public Theatre createtheatre(@RequestBody TheatreRequest theatreRequest){
        return theatreService.createTheatre(theatreRequest.getName(),theatreRequest.getAddress());
    }

    @GetMapping("/{theaterId}")
    public Theatre getTheatreById(@PathVariable String theaterId){
        return theatreService.getTheatreById(theaterId);
    }

    @GetMapping
    public List<Theatre> getTheatres(){
        return theatreService.getTheatres();
    }

}
