package com.ems.employeemanagementsystem.Repositories;

import com.ems.employeemanagementsystem.Models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    Users findUsersByEmailAndPassword(String email, String password);
    Users findUsersByEmail(String email);
    Users findUsersByFirstName(String firstName);
    Users findUsersByLastName (String lastName);

}
