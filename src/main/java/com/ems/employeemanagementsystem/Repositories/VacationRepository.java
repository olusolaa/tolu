package com.ems.employeemanagementsystem.Repositories;

import com.ems.employeemanagementsystem.Models.Users;
import com.ems.employeemanagementsystem.Models.Vacation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VacationRepository extends JpaRepository<Vacation, Long> {
    Vacation findVacationByTitle(String title);
    Vacation findVacationByDuration(Long duration);
    Void deleteVacationByUsers(Users users);
    List<Vacation> findAllByUsers(Users users);
}
