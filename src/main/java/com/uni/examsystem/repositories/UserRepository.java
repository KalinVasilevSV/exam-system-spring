package com.uni.examsystem.repositories;

import com.uni.examsystem.models.entities.UserEntity;
import com.uni.examsystem.models.entities.UserRoleEntity;
import com.uni.examsystem.models.entities.enums.UserRoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {

}
