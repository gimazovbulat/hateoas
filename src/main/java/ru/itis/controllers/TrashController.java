package ru.itis.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.itis.models.Resident;
import ru.itis.services.HotelService;

@RestController
@RequiredArgsConstructor
public class TrashController {
    private final HotelService hotelService;

    @PostMapping("/residents/wholeFloor")
    public Resident bookWholeFloor(@RequestBody Resident resident) {
        return hotelService.bookWholeFloor(resident);
    }
}
