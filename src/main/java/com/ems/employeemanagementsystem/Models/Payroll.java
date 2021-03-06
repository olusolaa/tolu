package com.ems.employeemanagementsystem.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Payroll extends BaseModel{
    private String firstName;
    private String lastName;
    private String month;
    private String description;
    private Long amount;
    @OneToMany
    private List<Salary> salary;

    @JsonIgnore
    @ManyToOne
    private Users users;
}