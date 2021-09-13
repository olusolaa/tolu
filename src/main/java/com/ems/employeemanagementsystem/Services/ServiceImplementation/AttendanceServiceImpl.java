package com.ems.employeemanagementsystem.Services.ServiceImplementation;

import com.ems.employeemanagementsystem.Exceptions.ResourceNotFoundException;
import com.ems.employeemanagementsystem.Models.Attendance;
import com.ems.employeemanagementsystem.ResponseBody.ResponseApi;
import com.ems.employeemanagementsystem.Models.Users;
import com.ems.employeemanagementsystem.Repositories.AttendanceRepository;
import com.ems.employeemanagementsystem.Repositories.UserRepository;
import com.ems.employeemanagementsystem.Services.AttendanceService;
import com.ems.employeemanagementsystem.config.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.MonthDay;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    LocalDateTime newStartDateTime;
    LocalDateTime newEndDateTime;

    @Override
    public ResponseApi markAttendance(HttpServletRequest request) {
        Optional<Users> users = jwtTokenProvider.resolveUser(request);
        System.err.println(users.get());
        ResponseApi response = new ResponseApi();
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalTime localTime = LocalTime.now();
        LocalDate localDate = LocalDate.now();
        String resumption = "08:00:00.000";
        String closing = "17:00:00.000";


        String temp1 = localDate+"T"+resumption;
        String temp2 = localDate+"T"+closing;
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");
        newStartDateTime = LocalDateTime.parse(temp1, dateTimeFormatter);
        newEndDateTime = LocalDateTime.parse(temp2, dateTimeFormatter);
        if (users.isPresent()) {
            if (localDateTime.isBefore(newStartDateTime)){
                response.setMessage( "Too early to mark attendance");
            }else if (localDateTime.isAfter(newEndDateTime)){
                response.setMessage("Too late to mark attendance");
            }else{
                Optional<Attendance> employeeAttendance = attendanceRepository.findByUsersAndAttendanceBetween(users.get(), newStartDateTime, newEndDateTime);

                if (employeeAttendance.isEmpty()) {
                    Attendance attendance = new Attendance();
                    attendance.setUsers(users.get());
                    if (localTime.isBefore(LocalTime.parse("09:00:00.000", DateTimeFormatter.ofPattern("HH:mm:ss.SSS")))) {
                        attendance.setIsLate(false);
                    }
                    attendance.setLocalTime(LocalTime.now());
                    attendance.setMonthDay(MonthDay.now());
                    response.setData(attendanceRepository.save(attendance));
                    response.setMessage("Attendance marked successfully");
                } else {
                    response.setMessage("Attendance already marked");
                }
            }
        } else {
            response.setMessage("User does not exist");
        }
        return response;
    }

    @Override
    public List<Attendance> getAttendanceByUser(HttpServletRequest request) {
        Optional<Users> users = jwtTokenProvider.resolveUser(request);
        if (users.isPresent()){
            return attendanceRepository.findAllByUsers(users.get());
        }else{
            throw new ResourceNotFoundException("user does not exist");
        }
    }

    @Override
    public List<Attendance> getAllUserAttendance() {
        return attendanceRepository.findAll();
    }

//    @Override
//    public Attendance getAttendanceById(Long id) {
//        Users users = userRepository.getById(id);
//        return attendanceRepository.findAttendanceByUsers(users);
//    }
}
