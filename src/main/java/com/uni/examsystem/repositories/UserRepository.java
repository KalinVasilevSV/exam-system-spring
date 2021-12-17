package com.uni.examsystem.repositories;

import com.uni.examsystem.models.entities.UserEntity;
import com.uni.examsystem.models.entities.UserRoleEntity;
import com.uni.examsystem.models.entities.enums.UserRoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByUsername(String username);

    Optional<UserEntity> findByUsernameIgnoreCase(String username);

    Optional<UserEntity> findByFacNoIgnoreCase(String facNum);

}
