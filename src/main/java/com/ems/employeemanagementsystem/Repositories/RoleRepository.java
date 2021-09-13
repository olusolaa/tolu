package com.ems.employeemanagementsystem.Repositories;

import com.ems.employeemanagementsystem.Models.RoleEnum;
import com.ems.employeemanagementsystem.Models.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Roles, Long> {
    Optional<Roles> findByRoleEnum(RoleEnum roleEnum);
}
