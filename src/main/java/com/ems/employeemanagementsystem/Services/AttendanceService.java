package com.ems.employeemanagementsystem.Services;


import com.ems.employeemanagementsystem.Models.Attendance;
import com.ems.employeemanagementsystem.Models.ResponseApi;
import com.ems.employeemanagementsystem.Models.Users;

import java.util.List;

public interface AttendanceService {
    ResponseApi markAttendance(Long id);
    List<Attendance> getAttendanceByUser(Users users);
    List<Attendance> getAllUserAttendance();
    Attendance getAttendanceById(Long id);
}
