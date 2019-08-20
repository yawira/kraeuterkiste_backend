package aw.krauterkiste.kraeuterkisteServer.repositories;

import aw.krauterkiste.kraeuterkisteServer.entities.Pictures;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PicturesRepository extends JpaRepository<Pictures, Long> {
}
