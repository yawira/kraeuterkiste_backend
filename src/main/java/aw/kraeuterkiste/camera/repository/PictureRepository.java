package aw.kraeuterkiste.camera.repository;

import aw.kraeuterkiste.camera.model.Picture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PictureRepository extends JpaRepository<Picture, Long> {
}
