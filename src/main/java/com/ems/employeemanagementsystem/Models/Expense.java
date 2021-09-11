package com.ems.employeemanagementsystem.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
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
    private String firstName;
    private String lastName;
    private enum status{
        APPROVED, DENIED, PENDING
    }
    @JsonIgnore
    @ManyToOne
    private Users users;
}
