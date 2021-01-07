package ru.itis.services;

import ru.itis.models.Resident;

public interface HotelService {
    Resident bookWholeFloor(Resident resident);
}
