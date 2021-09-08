package com.ems.employeemanagementsystem.Services.ServiceImplementation;

import com.ems.employeemanagementsystem.Models.Users;
import com.ems.employeemanagementsystem.Repositories.UserRepository;
import com.ems.employeemanagementsystem.RequestEntities.LoginRequest;
import com.ems.employeemanagementsystem.RequestEntities.SignupRequest;
import com.ems.employeemanagementsystem.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Users login(String email, String password) {
        return null;
    }

    @Override
    public Users signup(SignupRequest signupRequest) {
        Users users = new Users();
        users.setFirstName(signupRequest.getFirstName());
        users.setLastName(signupRequest.getLastName());
        users.setEmail(signupRequest.getEmail());
        users.setPassword(signupRequest.getPassword());
        users.setPhone(signupRequest.getPhone());
        users.setPin(signupRequest.getPin());

       return userRepository.save(users);

    }

    @Override
    public void deleteUser(Long id) {
        Optional<Users> users = userRepository.findById(id);
        userRepository.delete(users.get());
    }
}
