package com.uni.examsystem.service;

import com.uni.examsystem.models.binding.UserRegisterBindingModel;
import com.uni.examsystem.models.view.UserDetailsView;

public interface UserService {

    void initializeUsersAndRoles();

    boolean isUsernameFree(String username);

    boolean isFacNumFree(String facNumber);

    void registerAndLoginUser(UserRegisterBindingModel userModel);

    UserDetailsView findById(Long id, String currentUser);

    boolean canEdit(String username, Long id);
}
