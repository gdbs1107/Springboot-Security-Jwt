package com.example.jwt.service;

import com.example.jwt.Repository.UserRepository;
import com.example.jwt.dto.CustomUserDetails;
import com.example.jwt.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserEntity userEntity =userRepository.findByUsername(username);

        if(userEntity!=null){
            return new CustomUserDetails(userEntity);
        }


        return null;
    }
}
