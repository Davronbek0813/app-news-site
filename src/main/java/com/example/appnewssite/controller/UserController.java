package com.example.appnewssite.controller;

import com.example.appnewssite.payload.ApiResponse;
import com.example.appnewssite.payload.RegsiterDto;
import com.example.appnewssite.payload.UserDto;
import com.example.appnewssite.service.AuthService;
import com.example.appnewssite.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;
    @PostMapping("/register")
    public HttpEntity<?> registerUser(@Valid @RequestBody UserDto userDto){
        ApiResponse apiResponse=userService.addUser(userDto);
        return ResponseEntity.status(apiResponse.isSucces()?200:409).body(apiResponse);

    }
}
