package aw.krauterkiste.kraeuterkisteserver.repositories;

import aw.krauterkiste.kraeuterkisteserver.entities.Pump;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PumpRepository extends JpaRepository<Pump, Long> {
}
