package com.example.jwt.controller;

import com.example.jwt.Repository.UserRepository;
import com.example.jwt.dto.JoinDto;
import com.example.jwt.service.JoinService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class JoinController {

    private final JoinService joinService;

    @PostMapping("/join")
    public String joinProcess(JoinDto joinDto){

        joinService.joinProcess(joinDto);
        return "ok";
    }
}
