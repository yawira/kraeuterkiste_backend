package aw.kraeuterkiste.exposure.repository;

import aw.kraeuterkiste.exposure.model.Exposure;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExposureRepository extends JpaRepository<Exposure, Long> {

    List<Exposure> findAllByOrderByDateTimeDesc();

}
