package com.ems.employeemanagementsystem.Repositories;

import com.ems.employeemanagementsystem.Models.Attendance;
import com.ems.employeemanagementsystem.Models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Optional;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    Attendance findAttendanceByUsers(Users users);
    Attendance findAllById(Long id);
    Attendance findAttendanceByDateTime(LocalDateTime time);
    Attendance findAttendanceByTime(LocalTime time);
    Void deleteByUsers(Users users);
}
