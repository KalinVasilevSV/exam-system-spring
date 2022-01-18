package com.uni.examsystem.service.impl;

import com.uni.examsystem.models.binding.UserRegisterBindingModel;
import com.uni.examsystem.models.binding.UserUpdateBindingModel;
import com.uni.examsystem.models.entities.UserEntity;
import com.uni.examsystem.models.entities.UserRoleEntity;
import com.uni.examsystem.models.entities.enums.UserRoleEnum;
import com.uni.examsystem.models.view.UserDetailsView;
import com.uni.examsystem.repositories.UserRepository;
import com.uni.examsystem.repositories.UserRoleRepository;
import com.uni.examsystem.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final PasswordEncoder passwordEncoder;
    private final AppUserServiceImpl appUserService;
    private final ModelMapper modelMapper;


    public UserServiceImpl(UserRepository userRepository, UserRoleRepository userRoleRepository, PasswordEncoder passwordEncoder, AppUserServiceImpl appUserService, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.passwordEncoder = passwordEncoder;
        this.appUserService = appUserService;
        this.modelMapper = modelMapper;
    }


    @Override
    public void initializeUsersAndRoles() {
        initializeRoles();
        initializeUsers();
    }

    @Override
    public boolean isUsernameFree(String username) {

        return userRepository.findByUsernameIgnoreCase(username).isEmpty();
    }

    @Override
    public boolean isFacNumFree(String facNumber) {

        return userRepository.findByFacNoIgnoreCase(facNumber).isEmpty();
    }

    //TODO create a separate login method
    @Override
    public void registerAndLoginUser(UserRegisterBindingModel userModel) {
        UserRoleEntity userRole = userRoleRepository.findByRole(UserRoleEnum.USER);
        UserEntity newUser = new UserEntity();

        newUser.setUsername(userModel.getUsername());
        newUser.setPassword(passwordEncoder.encode(userModel.getPassword()));
        newUser.setFirstName(userModel.getFirstName());
        newUser.setLastName(userModel.getLastName());
        newUser.setFacNo(userModel.getFacultyNum());
        newUser.setRoles(Set.of(userRole));
        newUser = userRepository.save(newUser);

        UserDetails principal = appUserService.loadUserByUsername(newUser.getUsername());
        Authentication authentication = new UsernamePasswordAuthenticationToken(
                principal,
                newUser.getPassword(),
                principal.getAuthorities()
        );

        SecurityContext sc= new SecurityContextImpl();
        sc.setAuthentication(authentication);
        SecurityContextHolder.setContext(sc);
    }


    @Override
    public boolean canEdit(String username, Long id) {
        Optional<UserEntity> userOpt = userRepository.findById(id);
        Optional<UserEntity> caller = userRepository.findByUsername(username);

        if (userOpt.isEmpty() || caller.isEmpty()) {
            return false;
        } else {
            var userEntity = userOpt.get();
            return isAdmin(caller.get()) || userEntity.getUsername().equals(username);
        }

    }

    @Override
    public Optional<UserDetailsView> findByUserName(String username) {
        return userRepository.findByUsername(username)
                .map(userEntity -> {
                    var user = new UserDetailsView();
                    user.setId(userEntity.getId());
                    user.setFirstName(userEntity.getFirstName());
                    user.setLastName(userEntity.getLastName());
                    user.setUsername(userEntity.getUsername());
                    user.setFacNo(userEntity.getFacNo());
                    user.setCanEdit(true);
                    return user;
                });
    }

    @Override
    public Optional<UserEntity> findByFacNumber(String facNumber) {
        return userRepository.findByFacNoIgnoreCase(facNumber);
    }

    @Override
    public void updateUser(UserUpdateBindingModel userModel) {
        var userEntity = userRepository.findById(userModel.getId()).orElseThrow();

        if (userModel.getCurrentPassword().isBlank()) {
            userEntity.setFirstName(userModel.getFirstName());
            userEntity.setLastName(userModel.getLastName());
            userEntity.setPassword(userModel.getPassword());
        } else if (userModel.getCurrentPassword().equals(userEntity.getPassword())
                && userModel.getPassword().equals(userModel.getConfirmPassword())) {
            userEntity.setPassword(userModel.getPassword());
        }

        userRepository.save(userEntity);


    }

    @Override
    public UserDetailsView findById(Long id) {

        return userRepository.findById(id)
                .map(userEntity -> modelMapper.map(userEntity, UserDetailsView.class)).orElseThrow();
    }

    @Override
    public List<UserDetailsView> getAllUsers() {

        return userRepository.findAll()
                .stream()
                .map(userEntity -> modelMapper.map(userEntity, UserDetailsView.class)).collect(Collectors.toList());
    }

    private boolean isAdmin(UserEntity user) {
        return user.getRoles()
                .stream().map(UserRoleEntity::getRole).anyMatch(r -> r == UserRoleEnum.ADMIN);
    }

    private UserDetailsView mapUserDetailsView(String currentUser, UserEntity userEntity) {

        var userDetailsView = modelMapper.map(userEntity, UserDetailsView.class);
        userDetailsView.setCanEdit(canEdit(currentUser, userEntity.getId()));
        return userDetailsView;
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


            UserEntity pesho = new UserEntity();
            pesho.setUsername("pesho");
            pesho.setPassword(passwordEncoder.encode("pass"));
            pesho.setFirstName("Pesho");
            pesho.setLastName("Peshov");
            pesho.setFacNo("0123456789");
            pesho.setRoles(Set.of(userRole));

            userRepository.saveAll(List.of(admin, pesho));


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
