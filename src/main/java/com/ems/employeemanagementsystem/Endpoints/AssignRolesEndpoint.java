package com.ems.employeemanagementsystem.Endpoints;


import com.ems.employeemanagementsystem.Models.RoleEnum;
import com.ems.employeemanagementsystem.Services.ServiceImplementation.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping
public class AssignRolesEndpoint {

    @Autowired
    private UserServiceImpl userService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/assign-role/{id}")
    public ResponseEntity<?> assignRole (RoleEnum roleEnum, @PathVariable Long id){
        return userService.assignRole(roleEnum, id);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/remove-role/{id}")
    public ResponseEntity<?> removeRole (RoleEnum roleEnum, @PathVariable Long id){
        return userService.removeRole(roleEnum, id);
    }
}
