package aw.krauterkiste.exposure.repository;

import aw.krauterkiste.exposure.model.Exposure;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExposureRepository extends JpaRepository<Exposure, Long> {

    List<Exposure> findAllByOrderByDateTimeDesc();

}
