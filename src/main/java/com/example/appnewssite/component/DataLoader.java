package com.example.appnewssite.component;

import com.example.appnewssite.entity.Role;
import com.example.appnewssite.entity.User;
import com.example.appnewssite.entity.enums.Permission;
import com.example.appnewssite.repository.RoleRepository;
import com.example.appnewssite.repository.UserRepository;
import com.example.appnewssite.utils.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;

import static com.example.appnewssite.entity.enums.Permission.*;

@Component

public class DataLoader implements CommandLineRunner {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Value("${spring.sql.init.mode}")
    private String initialMode;

    @Override
    public void run(String... args) throws Exception {
        if(initialMode.equals("always")){
            Permission[] permissions = Permission.values();

            Role admin = roleRepository.save(new Role(
                    AppConstants.ADMIN,
                    "Sistema egasi",
                    Arrays.asList(permissions)
            ));

            Role user = roleRepository.save(new Role(
                    AppConstants.USER,
                    "Foydalanuvchi",
                    Arrays.asList(ADD_COMMENT, DELETE_MY_COMMENT, EDIT_COMMENT)

            ));

            userRepository.save(new User(
                    "Admin",
                    "admin",
                    passwordEncoder.encode("admin123"),
                    admin,
                    true
            ));

            userRepository.save(new User(
                    "User",
                    "user",
                    passwordEncoder.encode("user123"),
                    user,
                    true
            ));

        }

    }
}
