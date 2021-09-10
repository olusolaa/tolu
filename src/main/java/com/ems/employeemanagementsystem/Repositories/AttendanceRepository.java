package com.ems.employeemanagementsystem.Repositories;

import com.ems.employeemanagementsystem.Models.Attendance;
import com.ems.employeemanagementsystem.Models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    Attendance findAttendanceByUsers(Users users);
    Attendance findAllById(Long id);
    Void deleteByUsers(Users users);
    Optional<Attendance> findByUsersAndAttendanceBetween(Users users, LocalDateTime resumption, LocalDateTime closing);
    List<Attendance> findAllByUsers(Users users);


}
