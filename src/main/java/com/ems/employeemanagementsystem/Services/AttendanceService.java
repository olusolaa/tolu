package com.ems.employeemanagementsystem.Services;


import com.ems.employeemanagementsystem.Models.Attendance;
import com.ems.employeemanagementsystem.ResponseBody.ResponseApi;
import com.ems.employeemanagementsystem.Models.Users;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface AttendanceService {
    ResponseApi markAttendance(HttpServletRequest request);
    List<Attendance> getAttendanceByUser(HttpServletRequest request);
    List<Attendance> getAllUserAttendance();
//    Attendance getAttendanceById(Long id);
}
