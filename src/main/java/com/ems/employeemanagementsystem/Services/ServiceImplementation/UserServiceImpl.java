package com.ems.employeemanagementsystem.Services.ServiceImplementation;

import com.ems.employeemanagementsystem.Models.Users;
import com.ems.employeemanagementsystem.RequestEntities.LoginRequest;
import com.ems.employeemanagementsystem.RequestEntities.SignupRequest;
import com.ems.employeemanagementsystem.Services.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public Users login(LoginRequest loginRequest) {
        return null;
    }

    @Override
    public Users signup(SignupRequest signupRequest) {
        return null;
    }
}
