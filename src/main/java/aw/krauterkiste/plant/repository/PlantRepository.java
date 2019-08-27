package aw.krauterkiste.plant.repository;

import aw.krauterkiste.plant.model.Plant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlantRepository extends JpaRepository<Plant, Long> {
}
