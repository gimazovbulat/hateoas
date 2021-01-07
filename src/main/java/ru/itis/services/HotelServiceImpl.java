package ru.itis.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.models.Resident;
import ru.itis.repositories.ResidentRepository;

@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {
    private final ResidentRepository residentRepository;

    @Transactional
    @Override
    public Resident bookWholeFloor(Resident resident) {
        resident.bookWholeFloor();

        return residentRepository.save(resident);
    }
}
