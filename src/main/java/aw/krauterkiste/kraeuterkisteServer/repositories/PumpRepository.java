package aw.krauterkiste.kraeuterkisteServer.repositories;

import aw.krauterkiste.kraeuterkisteServer.entities.Pump;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PumpRepository extends JpaRepository<Pump, Long> {
}
