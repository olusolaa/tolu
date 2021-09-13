package com.ems.employeemanagementsystem.bootsrapadmin;

import com.ems.employeemanagementsystem.Models.RoleEnum;
import com.ems.employeemanagementsystem.Models.Roles;
import com.ems.employeemanagementsystem.Models.Users;
import com.ems.employeemanagementsystem.Repositories.RoleRepository;
import com.ems.employeemanagementsystem.Repositories.UserRepository;
import com.ems.employeemanagementsystem.Services.ServiceImplementation.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Adds the first
 * user as admin
 * to database
 */
@Component
public class BootstrapAdmin implements ApplicationListener<ContextRefreshedEvent> {
    private boolean dataAlreadySetup = false;
    private final UserServiceImpl employeeService;
    private final UserRepository employeeRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public BootstrapAdmin(UserServiceImpl employeeService, UserRepository employeeRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.employeeService = employeeService;
        this.employeeRepository = employeeRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        loadFirstUserAsAdmin();
    }
    private void loadFirstUserAsAdmin() {
        List<Users> users = employeeService.getAllUsers();
        if (dataAlreadySetup || users.size() > 0) return;
        Users admin = new Users();

        admin.setEmail("toluwaset@gmail.com");
        admin.setFirstName("Tee");
        admin.setLastName("tom");
        admin.setPassword(passwordEncoder.encode("toluwase"));
        admin.setPin("1234");
        admin.setPhone("123356768");
        admin.setUsername("tol");

        Roles role1 = new Roles(RoleEnum.ADMIN);
        Roles role2 = new Roles(RoleEnum.EMPLOYEE);

        roleRepository.save(role2);
        Roles roledb = roleRepository.save(role1);


        admin.setRoles(List.of(roledb));
        employeeRepository.save(admin);
        dataAlreadySetup =   true;
    }
}
