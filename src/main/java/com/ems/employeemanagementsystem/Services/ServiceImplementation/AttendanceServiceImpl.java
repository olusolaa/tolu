package com.ems.employeemanagementsystem.Services.ServiceImplementation;

import com.ems.employeemanagementsystem.Models.Attendance;
import com.ems.employeemanagementsystem.Models.Employee;
import com.ems.employeemanagementsystem.Models.ResponseApi;
import com.ems.employeemanagementsystem.Models.Users;
import com.ems.employeemanagementsystem.Repositories.AttendanceRepository;
import com.ems.employeemanagementsystem.Repositories.UserRepository;
import com.ems.employeemanagementsystem.Services.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

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

    LocalDateTime newStartDateTime;
    LocalDateTime newEndDateTime;
//    @PutMapping("/{id}")
//    @Override
//    public User updateUser (@RequestBody User user, @PathVariable("id") long userId){
//        User existingUser = getUserById(userId);
//        existingUser.setEmail(user.getEmail());
//        existingUser.setFirstName(user.getFirstName());
//        existingUser.setLastName(user.getLastName());
//        existingUser.setPassword(user.getPassword());
//        existingUser.setPhoneNumber(user.getPhoneNumber());
//
//        return this.userRepository.save(existingUser);
//
//    }


    @Override
    public ResponseApi markAttendance(Long id) {
        Users users = userRepository.getById(id);
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
        if (localDateTime.isBefore(newStartDateTime)){
            response.setMessage( "Too early to mark attendance");
        }else if (localDateTime.isAfter(newEndDateTime)){
            response.setMessage("Too late to mark attendance");
        }else{
            Optional<Attendance> employeeAttendance = attendanceRepository.findByUsersAndAttendanceBetween(users, newStartDateTime, newEndDateTime);
            if (employeeAttendance.isEmpty()) {
                Optional<Users> usersDb = userRepository.findById(users.getId());
                Attendance attendance = new Attendance();
                attendance.setUsers(usersDb.get());
                if (localTime.isBefore(LocalTime.parse("09:00:00.000", DateTimeFormatter.ofPattern("HH:mm:ss.SSS")))){
                    attendance.setIsLate(false);
                }
                attendance.setLocalTime(LocalTime.now());
                attendance.setMonthDay(MonthDay.now());
                attendanceRepository.save(attendance);
                response.setMessage("Attendance marked successfully");
            }else{
                response.setMessage( "Attendance already marked");
            }
        }
        response.setData(users);
        return response;
    }

    @Override
    public List<Attendance> getAttendanceByUser(Users users) {
        return null;
    }

    @Override
    public List<Attendance> getAllUserAttendance() {
        return null;
    }

    @Override
    public Attendance getAttendanceById(Long id) {
        Users users = userRepository.getById(id);
        return attendanceRepository.findAttendanceByUsers(users);
    }
}
