package com.example.appnewssite.service;

import com.example.appnewssite.entity.User;
import com.example.appnewssite.exseptions.ResourseNotFoundExceptions;
import com.example.appnewssite.payload.ApiResponse;
import com.example.appnewssite.payload.RegsiterDto;
import com.example.appnewssite.repository.RoleRepository;
import com.example.appnewssite.repository.UserRepository;
import com.example.appnewssite.utils.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public ApiResponse registerUser(RegsiterDto regsiterDto) {
        if (!regsiterDto.getPassword().equals(regsiterDto.getPrePassword())) {
            return new ApiResponse("Parollar mos emas", false);
        }
        if (userRepository.existsByUsername(regsiterDto.getUsername())) {
            return new ApiResponse("Bunday username avval ro'yxatdan o'tgan", false);
        }
        User user = new User(
                regsiterDto.getFullName(),
                regsiterDto.getUsername(),
                passwordEncoder.encode(regsiterDto.getPassword()),
                roleRepository.findByName(AppConstants.USER).orElseThrow(() -> new ResourseNotFoundExceptions("role", "name", AppConstants.USER)),
                true
                );

        userRepository.save(user);
        return new ApiResponse("Muvaffaqiyatli ro'yxatdan o'tdingiz",true) ;
    }

    public UserDetails loadUserByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(()->new UsernameNotFoundException(username));

    }
}
