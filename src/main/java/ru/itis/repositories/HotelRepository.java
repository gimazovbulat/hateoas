package ru.itis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.models.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, String> {
}
