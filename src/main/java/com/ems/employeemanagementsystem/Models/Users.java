package com.ems.employeemanagementsystem.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Users extends BaseModel{
    private String firstName;
    private String lastName;
    private String username;
    @Column(unique = true)
    private String email;
    private String password;
    private String address;
    private String phone;
    private String pin;
    private enum gender {
        MALE, FEMALE, OTHERS
    }
    private enum role{
        JUNIOR, SENIOR, MANAGEMENT
    }
    private  Long Salary;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Vacation> vacations;

    @OneToMany
    private List<Attendance> attendance;

    @OneToMany
    private List<Misconduct> misconducts;
    @OneToMany
    private List<Payroll> payrolls;

}