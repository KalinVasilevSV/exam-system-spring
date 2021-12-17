package com.uni.examsystem.service;

import com.uni.examsystem.models.binding.UserRegisterBindingModel;

public interface UserService {

    void initializeUsersAndRoles();

    boolean isUsernameFree(String username);

    boolean isFacNumFree(String facNumber);

    void registerAndLoginUser(UserRegisterBindingModel userModel);
}
