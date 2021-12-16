package com.uni.examsystem.service.impl;

import com.uni.examsystem.models.entities.UserEntity;
import com.uni.examsystem.models.entities.UserRoleEntity;
import com.uni.examsystem.models.entities.enums.UserRoleEnum;
import com.uni.examsystem.repositories.UserRepository;
import com.uni.examsystem.repositories.UserRoleRepository;
import com.uni.examsystem.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final PasswordEncoder passwordEncoder;


    public UserServiceImpl(UserRepository userRepository, UserRoleRepository userRoleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public void initializeUsersAndRoles() {
        initializeRoles();
        initializeUsers();
    }


    private void initializeUsers() {
        if (userRepository.count() == 0) {

            UserRoleEntity adminRole = userRoleRepository.findByRole(UserRoleEnum.ADMIN);
            UserRoleEntity userRole = userRoleRepository.findByRole(UserRoleEnum.USER);

            UserEntity admin = new UserEntity();
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("pass"));
            admin.setFirstName("Admin");
            admin.setLastName("Adminov");
            admin.setFacNo("11111111111");
            admin.setRoles(Set.of(adminRole, userRole));
            //todo implement setExams() for users

            userRepository.save(admin);


            UserEntity pesho = new UserEntity();
            pesho.setUsername("pesho");
            pesho.setPassword(passwordEncoder.encode("pass"));
            pesho.setFirstName("Pesho");
            pesho.setLastName("Peshov");
            pesho.setFacNo("0123456789");
            pesho.setRoles(Set.of(userRole));

            userRepository.save(pesho);


        }
    }

    private void initializeRoles() {
        if (userRoleRepository.count() == 0) {
            UserRoleEntity adminRole = new UserRoleEntity();
            adminRole.setRole(UserRoleEnum.ADMIN);
            UserRoleEntity userRole = new UserRoleEntity();
            userRole.setRole(UserRoleEnum.USER);

            userRoleRepository.saveAll(List.of(adminRole, userRole));
        }
    }

}
