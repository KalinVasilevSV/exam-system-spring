package com.uni.examsystem.service.impl;

import com.uni.examsystem.models.entities.UserEntity;
import com.uni.examsystem.repositories.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppUserServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public AppUserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException("Username " + username + " is not found!"));
        return mapUserEntityToUserDetails(user);
    }

    private UserDetails mapUserEntityToUserDetails(UserEntity user) {
        List<GrantedAuthority> authorities = user.getRoles()
                .stream()
                .map(r -> new SimpleGrantedAuthority("ROLE_" + r.getRole().name()))
                .collect(Collectors.toList());

        return new AppUser(user.getUsername(), user.getPassword(), authorities);
    }
}
