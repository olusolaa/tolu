package com.ems.employeemanagementsystem.RequestEntities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.MonthDay;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AttendanceRequest {
    private LocalDateTime attendance;
    private boolean status;
    private MonthDay month;
    private LocalTime time;
}
