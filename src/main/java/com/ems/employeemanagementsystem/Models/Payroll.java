package com.ems.employeemanagementsystem.Models;

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
    private String description;
    private enum status{
        PAID, UNPAID
    }

    private enum month{
//        PAID, UNPAID
    }

    @OneToMany
    private List<Salary> salary;

    @ManyToOne
    private Users users;
}