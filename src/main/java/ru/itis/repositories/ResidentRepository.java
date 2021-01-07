package ru.itis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.models.Resident;

public interface ResidentRepository extends JpaRepository<Resident, String> {
}
