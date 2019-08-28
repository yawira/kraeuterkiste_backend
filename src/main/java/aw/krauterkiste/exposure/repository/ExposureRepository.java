package aw.krauterkiste.exposure.repository;

import aw.krauterkiste.exposure.model.Exposure;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExposureRepository extends JpaRepository<Exposure, Long> {

    Exposure findTopByOrderByExposureDateTimeDesc();
}