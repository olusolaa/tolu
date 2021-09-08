package com.ems.employeemanagementsystem.bootsrapadmin;

import com.ems.employeemanagementsystem.Models.Roles;
import com.ems.employeemanagementsystem.Models.UserEnum;
import com.ems.employeemanagementsystem.Models.Users;
import com.ems.employeemanagementsystem.Repositories.UserRepository;
import com.ems.employeemanagementsystem.RequestEntities.SignupRequest;
import com.ems.employeemanagementsystem.Services.ServiceImplementation.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
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
    private UserRepository employeeRepository;

    @Autowired
    public BootstrapAdmin(UserServiceImpl employeeService, UserRepository employeeRepository) {
        this.employeeService = employeeService;
        this.employeeRepository = employeeRepository;
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
        admin.setPassword("toluwase");
        admin.setPin("1234");
        admin.setPhone("123356768");
        admin.setUsername("tol");
        admin.setUserEnum(UserEnum.ADMIN);
        employeeRepository.save(admin);
        dataAlreadySetup =   true;
    }
}
