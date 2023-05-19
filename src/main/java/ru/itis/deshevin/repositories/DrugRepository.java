package ru.itis.deshevin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.deshevin.models.DrugEntity;

import java.util.UUID;

public interface DrugRepository extends JpaRepository<DrugEntity, UUID> {
}
