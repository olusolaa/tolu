package com.ems.employeemanagementsystem.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Expense extends BaseModel{
    private String title;
    private String description;
    private Long amount;
    private enum status{
        APPROVED, DENIED, PENDING
    }
    @ManyToOne
    private Users users;
}
