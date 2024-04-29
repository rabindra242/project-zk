package org.example.practisequerydslcrud.controller;

import lombok.RequiredArgsConstructor;
import org.example.practisequerydslcrud.dto.request.LoginRequest;
import org.example.practisequerydslcrud.dto.request.LoginResponse;
import org.example.practisequerydslcrud.dto.request.ReqRes;
import org.example.practisequerydslcrud.service.UserManageMentService;
import org.example.practisequerydslcrud.utils.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class UserController {

    private final UserManageMentService userManageMentService;


    @PostMapping("/register")
    public ResponseEntity<Response<ReqRes>> register(@RequestBody ReqRes reqRes) {

        Response<ReqRes> response=new Response<>();
        response.setMessage("ok");
        response.setStatus(HttpStatus.CREATED.value());
        response.setResponse(userManageMentService.registerUser(reqRes));
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<Response<LoginResponse>> login(@RequestBody LoginRequest loginRequest) {
        Response<LoginResponse> response=new Response<>();
        response.setResponse(userManageMentService.login(loginRequest));
        return ResponseEntity.ok(response);
    }
}
