package com.ems.employeemanagementsystem.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private String email;
    private String password;
    private Long pin;
    private String phone;
}
