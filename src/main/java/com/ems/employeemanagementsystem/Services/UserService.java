package com.ems.employeemanagementsystem.Services;

import com.ems.employeemanagementsystem.Models.Users;
import com.ems.employeemanagementsystem.RequestEntities.SignupRequest;

public interface UserService {
    Users login (String email, String password);
    Users signup (SignupRequest signupRequest);
    void deleteUser(Long id);
    Users getAllUsers();
    Users getUserById(Long id);
    Users getUserByName(String name);

}
