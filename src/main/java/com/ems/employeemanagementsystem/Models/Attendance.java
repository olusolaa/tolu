package com.ems.employeemanagementsystem.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.MonthDay;

@Getter
@Setter
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Attendance extends BaseModel {
    @CreationTimestamp
    private LocalDateTime dateTime;
    private boolean status;
    private MonthDay month;
    private LocalTime time;

    @ManyToOne
    private Users users;
    @ManyToOne
    private Users employee;
}
