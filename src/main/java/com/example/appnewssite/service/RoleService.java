package com.example.appnewssite.service;

import com.example.appnewssite.entity.Role;
import com.example.appnewssite.payload.ApiResponse;
import com.example.appnewssite.payload.RoleDto;
import com.example.appnewssite.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    RoleRepository roleRepository;
    public ApiResponse addRole(RoleDto roleDto) {

        if (roleRepository.existsByName(roleDto.getName())) {
            return new ApiResponse("Bunday lavozim allaqachon mavjud",false);
        }

        Role role=new Role(
                roleDto.getName(),
                roleDto.getDescription(),
                roleDto.getPermissionList());

        roleRepository.save(role);
        return new ApiResponse("Saqlandi",true);
    }

    public ApiResponse editRole(Long id, RoleDto roleDto) {
        return new ApiResponse("",true);
    }
}
