package com.example.appnewssite.controller;

import com.example.appnewssite.entity.User;
import com.example.appnewssite.payload.ApiResponse;
import com.example.appnewssite.payload.LoginDto;
import com.example.appnewssite.payload.RegsiterDto;
import com.example.appnewssite.security.JwtProvider;
import com.example.appnewssite.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthService authService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtProvider jwtProvider;
    @PostMapping("/register")
    public HttpEntity<?> registerUser(@Valid @RequestBody RegsiterDto regsiterDto){
        ApiResponse apiResponse=authService.registerUser(regsiterDto);
        return ResponseEntity.status(apiResponse.isSucces()?200:409).body(apiResponse);

    }

    @PostMapping("/login")
    public HttpEntity<?> loginUser(@Valid @RequestBody LoginDto loginDto){
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));
        User user = (User) authenticate.getPrincipal();
        String token = jwtProvider.generatedToken(user.getUsername(), user.getRole());
        return ResponseEntity.ok(token);

    }
}
