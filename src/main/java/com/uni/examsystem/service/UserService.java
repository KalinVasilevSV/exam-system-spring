package com.uni.examsystem.service;

import com.uni.examsystem.models.binding.UserRegisterBindingModel;
import com.uni.examsystem.models.entities.UserEntity;
import com.uni.examsystem.models.view.UserDetailsView;

import java.util.Optional;
import java.util.Set;

public interface UserService {

    void initializeUsersAndRoles();

    boolean isUsernameFree(String username);

    boolean isFacNumFree(String facNumber);

    void registerAndLoginUser(UserRegisterBindingModel userModel);


    boolean canEdit(String username, Long id);

    Optional<UserDetailsView> findByUserName(String username);

    Optional<UserEntity> findByFacNumber(String facNumber);
}
