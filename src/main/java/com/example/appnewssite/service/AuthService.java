package com.example.appnewssite.service;

import com.example.appnewssite.entity.User;
import com.example.appnewssite.payload.ApiResponse;
import com.example.appnewssite.payload.RegsiterDto;
import com.example.appnewssite.repository.RoleRepository;
import com.example.appnewssite.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;
    public ApiResponse registerUser(RegsiterDto regsiterDto) {
        if (userRepository.existsByUsername(regsiterDto.getUsername())) {
            return new ApiResponse("Bunday username avval ro'yxatdan o'tgan",false);
        }
//        User user=new User(
//                regsiterDto.getFullName(),
//                regsiterDto.getUsername(),
//                null,
//
//        );
        return null;
    }
}
