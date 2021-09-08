package com.ems.employeemanagementsystem.Endpoints;

import com.ems.employeemanagementsystem.Models.Users;
import com.ems.employeemanagementsystem.RequestEntities.ActivateRequest;
import com.ems.employeemanagementsystem.Services.ServiceImplementation.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class ActivateUser {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/activate/{id}")
    public ResponseEntity<?> activateUser (@RequestBody ActivateRequest  activateRequest, @PathVariable Long id){
        userService.activateUser(activateRequest, id);
        return new ResponseEntity<>("Activation Successful", HttpStatus.OK);
    }
}
