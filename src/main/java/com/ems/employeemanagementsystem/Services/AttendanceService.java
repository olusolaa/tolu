package com.ems.employeemanagementsystem.Services;


import com.ems.employeemanagementsystem.Models.Attendance;
import com.ems.employeemanagementsystem.Models.Employee;
import com.ems.employeemanagementsystem.Models.Users;

import java.util.List;

public interface AttendanceService {
    String markAttendance(Employee employee);
    List<Attendance> getAttendanceByUser(Users users);
    List<Attendance> getAllEmployeeAttendance();
    Attendance getAttendanceById(Long id);
}
