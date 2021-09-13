package com.ems.employeemanagementsystem.Services;

import com.ems.employeemanagementsystem.Models.RoleEnum;
import com.ems.employeemanagementsystem.Models.Users;
import com.ems.employeemanagementsystem.RequestEntities.SignupRequest;
import com.ems.employeemanagementsystem.ResponseBody.ResponseApi;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    ResponseEntity<?> login (String email, String password);
    ResponseApi signup (SignupRequest signupRequest);
    void deleteUser(Long id);
    List<Users> getAllUsers();
    Optional<Users> getUserById(Long id);
    Users getUserByFirstName(String firstName);
    Users getUserByFirstAndLastName(String firstName, String lastName);
    Users getUserByLastName(String lastName);
    ResponseEntity<?> assignRole(RoleEnum roleEnum, Long id);
    ResponseEntity<?> removeRole(RoleEnum roleEnum, Long id);

}
