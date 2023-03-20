package com.example.appnewssite.payload;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegsiterDto {

    @NotNull(message = "fullName  bo'sh bo'lmasligi kerak")
    private String fullName;

    @NotNull(message = "username bo'sh bo'lmasligi kerak")
    private  String username;

    @NotNull(message = "Parol bo'sh bo'lmasligi kerak")
    private String password;

    @NotNull(message = "Takroriy parol bo'sh bo'lmasligi kerak")
    private String prePassword;
}
