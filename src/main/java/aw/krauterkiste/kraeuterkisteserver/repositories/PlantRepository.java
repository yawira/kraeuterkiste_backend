package aw.krauterkiste.kraeuterkisteserver.repositories;

import aw.krauterkiste.kraeuterkisteserver.entities.Plant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlantRepository extends JpaRepository<Plant, Long> {
}
