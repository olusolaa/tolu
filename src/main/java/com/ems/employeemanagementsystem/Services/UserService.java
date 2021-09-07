package com.ems.employeemanagementsystem.Services;

import com.ems.employeemanagementsystem.Models.Users;
import com.ems.employeemanagementsystem.RequestEntities.LoginRequest;
import com.ems.employeemanagementsystem.RequestEntities.SignupRequest;

public interface UserService {
    Users login (LoginRequest loginRequest);
    Users signup (SignupRequest signupRequest);
    Void deleteUser(Long id);

}
