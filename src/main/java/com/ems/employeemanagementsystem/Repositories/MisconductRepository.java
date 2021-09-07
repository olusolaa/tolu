package com.ems.employeemanagementsystem.Repositories;

import com.ems.employeemanagementsystem.Models.Misconduct;
import com.ems.employeemanagementsystem.Models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MisconductRepository extends JpaRepository<Misconduct,Long> {
    Misconduct findMisconductByUsers(Users users);
    Misconduct findAllById();
    Misconduct findMisconductByFirstName(String firstName);
    Optional<Misconduct> findById();
    Void deleteByUsers();
}
