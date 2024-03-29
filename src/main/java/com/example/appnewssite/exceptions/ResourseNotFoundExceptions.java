package com.example.appnewssite.exceptions;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
@AllArgsConstructor
public class ResourseNotFoundExceptions extends RuntimeException{

    private final String resourceName; //role

    private final String resourceField; //name

    private final Object object;  //USER, ADMIN
}
