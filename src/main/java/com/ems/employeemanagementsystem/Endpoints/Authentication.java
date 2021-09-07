package com.ems.employeemanagementsystem.Endpoints;

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

@RestController
@RequestMapping("/api")
public class Authentication {
    @Autowired
    private UsersServiceImpl usersService;


    @PostMapping("/login")
    public  ResponseEntity<?> login (@RequestBody LoginRequest loginRequest) throws UserPrincipalNotFoundException {

        Users users = usersService.loginByUsernameAndEmail(loginRequest.getEmailOrUsername(), loginRequest.getPassword());

        if(users == null){
            throw new UserPrincipalNotFoundException("User details not correct");
        }

        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    //create a user
    @PostMapping("/create")
    public  ResponseEntity<?> signup (@RequestBody UserRequest users){
        Users user = usersService.signup(users);
        return new ResponseEntity<>("Successful", HttpStatus.OK);
    }

    //method lists all created users
    @GetMapping("/all")
    public List<Users> getAllUsers() {
        return usersService.getAllUsers();
    }

    //get User By ID
    @GetMapping("/{id}")
    public Users getUserById (@PathVariable(value = "id") long userId) {
        return usersService.getUserById(userId);
    }


    @GetMapping("/getUser")
    public ResponseEntity<?> getUserByName(String name){
        Users user = usersService.getUserByName(name);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }





//    @Autowired
//    AuthService authService;
//
//    @PostMapping("/signup")
//    public ResponseEntity<User> signup (@RequestBody LevelOneInfo levelOneInfo) {
//        User user = authService.signup(levelOneInfo);
//        return ResponseEntity.status(HttpStatus.OK).body(user);
//    }
//
//    @PostMapping("/login")
//    public ResponseEntity<?> login (@RequestBody LoginRequest loginRequest) {
//        System.out.println(loginRequest.getEmail());
//        User user = authService.login(loginRequest.getEmail(), loginRequest.getPassword());
//        if(user == null){
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid credentials");
//        }
//        LoginResponse response = new LoginResponse(user.getEmail(),
//                user.getPin(), user.getPassword(), user.getAccountNumber());
//        return ResponseEntity.status(HttpStatus.OK).body(response);
//    }
}
