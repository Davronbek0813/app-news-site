package com.example.appnewssite.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    @NotNull(message = "fullName  bo'sh bo'lmasligi kerak")
    private String fullName;

    @NotNull(message = "username bo'sh bo'lmasligi kerak")
    private  String username;

    @NotNull(message = "Parol bo'sh bo'lmasligi kerak")
    private String password;

    @NotNull(message = "Role bo'sh bo'lmasligi kerak")
    private Long roleId;
}
