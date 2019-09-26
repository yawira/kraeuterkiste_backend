package aw.kraeuterkiste.pump.repository;

import aw.kraeuterkiste.pump.model.Pump;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PumpRepository extends JpaRepository<Pump, Long> {

    List<Pump> findAllByOrderByDateTimeDesc();
}