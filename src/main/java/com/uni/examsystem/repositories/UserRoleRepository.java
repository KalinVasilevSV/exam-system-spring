package com.uni.examsystem.repositories;

import com.uni.examsystem.models.entities.UserRoleEntity;
import com.uni.examsystem.models.entities.enums.UserRoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Long> {

    UserRoleEntity findByRole(UserRoleEnum role);
}
