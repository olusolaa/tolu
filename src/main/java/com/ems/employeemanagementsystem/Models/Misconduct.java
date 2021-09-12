package com.ems.employeemanagementsystem.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Misconduct extends BaseModel{
    private String firstName;
    private String lastName;
    private String subject;
    private String description;
    private enum status{
        OPEN, PENDING, COMPLETED
    }
    private String status;

    @JsonIgnore
    @ManyToOne
    private Users users;
}
