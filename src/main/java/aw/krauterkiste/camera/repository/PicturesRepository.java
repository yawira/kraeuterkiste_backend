package aw.krauterkiste.camera.repository;

import aw.krauterkiste.camera.model.Pictures;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PicturesRepository extends JpaRepository<Pictures, Long> {
}
