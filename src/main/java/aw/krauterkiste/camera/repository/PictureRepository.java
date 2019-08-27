package aw.krauterkiste.camera.repository;

import aw.krauterkiste.camera.model.Picture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PictureRepository extends JpaRepository<Picture, Long> {
}
