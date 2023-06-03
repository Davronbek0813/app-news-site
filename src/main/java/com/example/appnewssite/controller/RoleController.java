package com.example.appnewssite.controller;

import com.example.appnewssite.aop.CheckPermission;
import com.example.appnewssite.payload.ApiResponse;
import com.example.appnewssite.payload.RegsiterDto;
import com.example.appnewssite.payload.RoleDto;
import com.example.appnewssite.service.AuthService;
import com.example.appnewssite.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/role")
public class RoleController {

    @Autowired
    RoleService roleService;


    @PreAuthorize(value = "hasAuthority('ADD_ROLE')")
    @PostMapping
    public HttpEntity<?> addRole(@Valid @RequestBody RoleDto roleDto){
        ApiResponse apiResponse=roleService.addRole(roleDto);
        return ResponseEntity.status(apiResponse.isSucces()?200:409).body(apiResponse);
    }

//    @PreAuthorize(value = "hasAuthority('EDIT_ROLE')")
    @CheckPermission(value = "EDIT_ROLE")
    @PutMapping("/{id}")
    public HttpEntity<?> editRole(@PathVariable Long id, @Valid @RequestBody RoleDto roleDto){
        ApiResponse apiResponse=roleService.editRole(id,roleDto);
        return ResponseEntity.status(apiResponse.isSucces()?200:409).body(apiResponse);

    }
}
