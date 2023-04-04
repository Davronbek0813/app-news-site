package com.example.appnewssite.controller;

import com.example.appnewssite.payload.ApiResponse;
import com.example.appnewssite.payload.RegsiterDto;
import com.example.appnewssite.payload.RoleDto;
import com.example.appnewssite.service.AuthService;
import com.example.appnewssite.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/role")
public class RoleController {

    @Autowired
    RoleService roleService;


    @PostMapping
    public HttpEntity<?> registerUser(@Valid @RequestBody RoleDto roleDto){
        ApiResponse apiResponse=roleService.addRole(roleDto);
        return ResponseEntity.status(apiResponse.isSucces()?200:409).body(apiResponse);

    }
}
