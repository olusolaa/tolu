package com.ems.employeemanagementsystem.RequestEntities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Month;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PayrollRequest {
    private String firstName;
    private String lastName;
    private Month month;
    private String description;
    private Long amount;
}
