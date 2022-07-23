package com.click.controller;

import com.click.dto.profile.RegistrationDTO;
import com.click.dto.response.ApiResponse;
import com.click.model.ProfileEntity;
import com.click.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;


    @PostMapping("")
    public ResponseEntity<?> registration(@RequestBody @Valid RegistrationDTO dto){

        log.info("Registration  object = {}",dto);

        ApiResponse<ProfileEntity> response = authService.registration(dto);

        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

}
