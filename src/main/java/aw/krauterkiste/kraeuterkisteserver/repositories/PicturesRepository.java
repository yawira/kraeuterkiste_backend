package aw.krauterkiste.kraeuterkisteserver.repositories;

import aw.krauterkiste.kraeuterkisteserver.entities.Pictures;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PicturesRepository extends JpaRepository<Pictures, Long> {
}
