package com.ems.employeemanagementsystem.RequestEntities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SignupRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;
    private String phone;
    private String pin;
}
