package com.ems.employeemanagementsystem.Endpoints;


import com.ems.employeemanagementsystem.Models.Attendance;
import com.ems.employeemanagementsystem.ResponseBody.ResponseApi;
import com.ems.employeemanagementsystem.Services.ServiceImplementation.AttendanceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("user")
public class AttendanceEndpoint {
    @Autowired
    private AttendanceServiceImpl attendanceService;

    @PreAuthorize("hasAuthority('EMPLOYEE')")
    @PutMapping(path = "/mark-attendance/{id}")
    public ResponseEntity<ResponseApi> markAttendance(HttpServletRequest request){
        ResponseApi responseApi = attendanceService.markAttendance(request);
        return ResponseEntity.status(HttpStatus.OK).body(responseApi);
    }

    @PreAuthorize("hasAnyAuthority('EMPLOYEE')")
    @GetMapping("/attendance-history")
    public List<Attendance> getAttendanceHistory(HttpServletRequest request) {
       return attendanceService.getAttendanceByUser(request);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','EMPLOYEE')")
    @GetMapping("/all-history")
    public List<Attendance> getAllAttendanceHistory() {
        return attendanceService.getAllUserAttendance();
    }
}
