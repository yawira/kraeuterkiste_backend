package aw.krauterkiste.login.repository;

import aw.krauterkiste.login.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface IUserRepository extends JpaRepository<UserEntity, Integer>{

    UserEntity findByUsername(@Param("username") String username);
}
