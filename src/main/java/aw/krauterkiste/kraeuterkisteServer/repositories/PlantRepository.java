package aw.krauterkiste.kraeuterkisteServer.repositories;

import aw.krauterkiste.kraeuterkisteServer.entities.Plant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlantRepository extends JpaRepository<Plant, Long> {
}
