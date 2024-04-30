package org.example.practisequerydslcrud.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.practisequerydslcrud.dto.request.LoginRequest;
import org.example.practisequerydslcrud.dto.request.LoginResponse;
import org.example.practisequerydslcrud.dto.request.ReqRes;
import org.example.practisequerydslcrud.entity.User;
import org.example.practisequerydslcrud.repo.UserRepo;
import org.example.practisequerydslcrud.utils.JwtUtill;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Slf4j
@Service
@RequiredArgsConstructor

public class UserManageMentService {
    private final UserRepo userRepo;
    private final AuthenticationManager authenticationManager;
    private final JwtUtill jwtUtill;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;

    public ReqRes registerUser(ReqRes reqRes) {
        User user = new User();
        user.setUsername(reqRes.getUsername());
        user.setPassword(passwordEncoder.encode(reqRes.getPassword()));
        user.setEmail(reqRes.getEmail());
        user.setRole(reqRes.getRole());
        user.setPhoneNumber(reqRes.getPhoneNumber());
        userRepo.save(user);
        return modelMapper.map(user, ReqRes.class);

    }

    public LoginResponse login(LoginRequest loginResponse){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginResponse.getEmail(), loginResponse.getPassword()));
        User user = userRepo.findByEmail(loginResponse.getEmail()).orElse(null);
        var jwt=jwtUtill.generateToken(user);
        var refreshtoken=jwtUtill.generateRefreshToken(new HashMap<>(),user);
        log.info(jwt);
        log.info(refreshtoken);
        LoginResponse loginResponse1 = new LoginResponse();
        loginResponse1.setToken(jwt);
        loginResponse1.setEmail(loginResponse.getEmail());
        loginResponse1.setRole(user.getRole());
        return loginResponse1;
    }


}
