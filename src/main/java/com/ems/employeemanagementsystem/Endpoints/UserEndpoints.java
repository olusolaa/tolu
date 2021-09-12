package com.ems.employeemanagementsystem.Endpoints;

import com.ems.employeemanagementsystem.Exceptions.UserUnauthorised;
import com.ems.employeemanagementsystem.Models.Users;
import com.ems.employeemanagementsystem.RequestEntities.LoginRequest;
import com.ems.employeemanagementsystem.RequestEntities.SignupRequest;
import com.ems.employeemanagementsystem.Services.ServiceImplementation.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserEndpoints {
    @Autowired
    private UserServiceImpl userService;


    @PostMapping("/login")
    public  ResponseEntity<?> login (@RequestBody LoginRequest loginRequest) throws UserPrincipalNotFoundException {
        Users users = userService.login(loginRequest.getEmail(), loginRequest.getPassword());

        if(users == null){
            throw new UserPrincipalNotFoundException("User details not correct");
        }
        if (!users.isActivated()) {
            throw new UserUnauthorised("Account Inactive, Please contact Admin");
        }

        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    //create a user
    @PostMapping("/create")
    public  ResponseEntity<?> signup (@RequestBody SignupRequest signupRequest){
        Users user = userService.signup(signupRequest);
        return new ResponseEntity<>("Signup Successful", HttpStatus.OK);
    }

    //method lists all created users
    @GetMapping("/all")
    public List<Users> getAllUsers() {
        return this.userService.getAllUsers();
    }

    //get User By ID
    @GetMapping("/{id}")
    public Optional<Users> getUserById (@PathVariable(value = "id") long userId) {
        return userService.getUserById(userId);
    }


    @GetMapping("/first-name")
    public ResponseEntity<Users> getUserByFirstName(String firstName){
        Users user = userService.getUserByFirstName(firstName);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @GetMapping("/first-and-last-name")
    public ResponseEntity<Users> getUserByFirstAndLastName(String firstName){
        Users user = userService.getUserByFirstName(firstName);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @GetMapping("/last-name")
    public ResponseEntity<Users> getUserByLastName(String lastName){
        Users user = userService.getUserByLastName(lastName);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }



}
