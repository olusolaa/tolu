package com.ems.employeemanagementsystem.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
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
    private  Long Salary;
    private boolean activated;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Roles> roles = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY)
    private List<Vacation> vacations;

//    @OneToMany
//    private List<Attendance> attendance;

    @OneToMany
    private List<Misconduct> misconducts;
    @OneToMany
    private List<Payroll> payrolls;

}
