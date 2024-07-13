package com.example.jwt.service;

import com.example.jwt.Repository.UserRepository;
import com.example.jwt.dto.JoinDto;
import com.example.jwt.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JoinService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public void joinProcess(JoinDto joinDto){

        String username=joinDto.getUsername();
        String password= joinDto.getPassword();

        Boolean isExist = userRepository.existsByUsername(username);

        if (isExist){
            return;
        }

        UserEntity userEntity=new UserEntity();
        userEntity.setUsername(username);
        userEntity.setPassword(bCryptPasswordEncoder.encode(joinDto.getPassword()));
        userEntity.setRole("ROLE_ADMIN");

        userRepository.save(userEntity);
    }
}
