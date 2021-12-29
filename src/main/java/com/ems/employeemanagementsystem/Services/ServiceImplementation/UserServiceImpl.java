package com.ems.employeemanagementsystem.Services.ServiceImplementation;

import com.ems.employeemanagementsystem.Exceptions.ResourceNotFoundException;
import com.ems.employeemanagementsystem.Exceptions.UserUnauthorised;
import com.ems.employeemanagementsystem.Models.RoleEnum;
import com.ems.employeemanagementsystem.Models.Roles;
import com.ems.employeemanagementsystem.Models.Users;
import com.ems.employeemanagementsystem.Repositories.RoleRepository;
import com.ems.employeemanagementsystem.Repositories.UserRepository;
import com.ems.employeemanagementsystem.RequestEntities.ActivateRequest;
import com.ems.employeemanagementsystem.RequestEntities.SignupRequest;
import com.ems.employeemanagementsystem.ResponseBody.ResponseApi;
import com.ems.employeemanagementsystem.ResponseBody.UserResponseBody;
import com.ems.employeemanagementsystem.Services.UserService;
import com.ems.employeemanagementsystem.config.JwtAuthenticationResponse;
import com.ems.employeemanagementsystem.config.JwtTokenProvider;
import com.ems.employeemanagementsystem.config.UserDetailsServiceImpl;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserDetailsServiceImpl userDetailsService;
    private final AuthenticationManager authenticationManager;
    private final RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtTokenProvider jwtTokenProvider, UserDetailsServiceImpl userDetailsService, AuthenticationManager authenticationManager, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userDetailsService = userDetailsService;
        this.authenticationManager = authenticationManager;
        this.roleRepository = roleRepository;
    }

    @Override
    public ResponseEntity<?> login(String email, String password) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(email, password)
            );
            Optional<Users> user = userRepository.findByEmail(email);
//            var response = new ResponseApi();
            if (!user.get().isActivated()) {
//                response.setMessage("Account Inactive, Please Activate Account or Please contact Admin");
                throw new UserUnauthorised("Account Inactive, Please contact Admin");
            }
            final String jwt = jwtTokenProvider.generateToken(user.get().getEmail());
            return ResponseEntity.ok(new UserResponseBody(jwt, user.get()));
        } catch (BadCredentialsException e) {
            throw new UserUnauthorised("Incorrect email or password");
        }
    }

    @Override
    public ResponseApi signup(SignupRequest signupRequest) {

        Users users = new Users();
        var response = new ResponseApi();

        if (signupRequest.getUsername() == null) {
            response.setMessage("Username cannot be empty");
            return response;
        }

        if (signupRequest.getEmail() == null) {
            response.setMessage("Email is required");
            return response;
        }
        if (signupRequest.getPhone() == null) {
            response.setMessage("Phone Number is required");
            return response;
        }
        if (signupRequest.getFirstName() == null) {
            response.setMessage("Please supply your First Name");
            return response;
        }
        if (signupRequest.getPassword() == null) {
            response.setMessage("Please supply a password");
            return response;
        }

        if (userRepository.findByEmail(signupRequest.getEmail()).isPresent()) {
            response.setMessage("User with email" + signupRequest.getEmail() + " already exists, please supply a new email");
            return response;
        }
        if (userRepository.findByEmail(signupRequest.getEmail()).isPresent()) {
            response.setMessage("Email exist already, please supply a new email");
            return response;
        }

        users.setFirstName(signupRequest.getFirstName());
        users.setLastName(signupRequest.getLastName());
        users.setEmail(signupRequest.getEmail());
        users.setPassword(passwordEncoder.encode(signupRequest.getPassword()));
        users.setPhone(signupRequest.getPhone());
        users.setUsername(signupRequest.getUsername());
        Roles userRole = roleRepository.findByRoleEnum(RoleEnum.EMPLOYEE)
                .orElseThrow(() -> new ResourceNotFoundException("Role not set"));
        users.getRoles().add(userRole);
        userRepository.save(users);

        response.setMessage("User created Successfully");
        response.setData(users);
        return response;
    }

    public Users activateUser(ActivateRequest activateRequest, Long id) {
//        Users users = new Users();
        Users users = userRepository.getById(id);
        users.setActivated(true);
        return userRepository.save(users);
    }

    @Override
    public void deleteUser(Long id) {
        Optional<Users> users = userRepository.findById(id);
        userRepository.delete(users.get());
    }

    @Override
    public List<Users> getAllUsers() {
        return this.userRepository.findAll();
    }

    @Override
    public Optional<Users> getUserById(Long id) {
        return userRepository.findById(id);
    }


    @Override
    public Users getUserByFirstName(String firstName) {
        return userRepository.findAllByFirstName(firstName);
    }

    @Override
    public Users getUserByFirstAndLastName(String firstName, String lastName) {
        return userRepository.findAllByFirstNameAndLastName(firstName, lastName);
    }

    @Override
    public Users getUserByLastName(String lastName) {
        return userRepository.findAllByLastName(lastName);
    }

    @Override
    public ResponseEntity<?> assignRole(RoleEnum roleEnum, Long id) {
        Optional<Users> users = userRepository.findById(id);
        if (users.isPresent()) {
            Optional<Roles> role = roleRepository.findByRoleEnum(roleEnum);
            users.get().getRoles().add(role.get());
            return new ResponseEntity<>(userRepository.save(users.get()), HttpStatus.OK);
        } else {
            throw new ResourceNotFoundException("User not found");
        }
    }

    public ResponseEntity<?> removeRole(RoleEnum roleEnum, Long id) {
        Optional<Users> users = userRepository.findById(id);
        if (users.isPresent()) {
            Optional<Roles> role = roleRepository.findByRoleEnum(roleEnum);
            List<Roles> roleList = users.get().getRoles();
            roleList.remove(role.get());
            return new ResponseEntity<>(userRepository.save(users.get()), HttpStatus.OK);
        } else {
            throw new ResourceNotFoundException("User not found");
        }
    }
}
