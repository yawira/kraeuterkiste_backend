package aw.kraeuterkiste.moisture.repository;

import aw.kraeuterkiste.moisture.model.Moisture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MoistureRepository extends JpaRepository<Moisture, Long> {

    List<Moisture> findAllByOrderByDateTimeAsc();
}
