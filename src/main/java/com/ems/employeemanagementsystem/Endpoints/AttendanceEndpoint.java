package com.ems.employeemanagementsystem.Endpoints;


import com.ems.employeemanagementsystem.Models.Attendance;
import com.ems.employeemanagementsystem.Models.ResponseApi;
import com.ems.employeemanagementsystem.Models.Users;
import com.ems.employeemanagementsystem.Services.ServiceImplementation.AttendanceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class AttendanceEndpoint {
    @Autowired
    private AttendanceServiceImpl attendanceService;

    @PutMapping(path = "/mark-attendance/{id}")
    public ResponseEntity<ResponseApi> markAttendance(@PathVariable Long id){
        ResponseApi responseApi = attendanceService.markAttendance(id);
        return ResponseEntity.status(HttpStatus.OK).body(responseApi);
    }

    @GetMapping("/attendance-history/{id}")
    public Attendance getAttendanceById(Long id) {
       return attendanceService.getAttendanceById(id);
    }

}
