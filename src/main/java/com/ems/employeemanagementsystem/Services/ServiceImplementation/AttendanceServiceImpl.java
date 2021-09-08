package com.ems.employeemanagementsystem.Services.ServiceImplementation;

import com.ems.employeemanagementsystem.Models.Attendance;
import com.ems.employeemanagementsystem.Models.Employee;
import com.ems.employeemanagementsystem.Models.Users;
import com.ems.employeemanagementsystem.Repositories.AttendanceRepository;
import com.ems.employeemanagementsystem.Services.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Override
    public String markAttendance(Employee employee) {
        return null;
    }

    @Override
    public List<Attendance> getAttendanceByUser(Users users) {
        return null;
    }

    @Override
    public List<Attendance> getAllEmployeeAttendance() {
        return null;
    }

    @Override
    public Attendance getAttendanceById(Long id) {
        return null;
    }
}
