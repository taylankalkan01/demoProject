package com.example.demoProject.dto;

import lombok.Data;


import java.util.List;

@Data
public class UserDto {

    private Long id;
    private String firstName;
    private String lastName;
    private List<String> addresses;

}
