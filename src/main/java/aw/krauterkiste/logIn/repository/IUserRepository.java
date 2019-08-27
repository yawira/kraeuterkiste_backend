package aw.krauterkiste.logIn.repository;

import aw.krauterkiste.logIn.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface IUserRepository extends JpaRepository<UserEntity, Integer>{

    UserEntity findByUsername(@Param("username") String username);
}
