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
public class Task extends BaseModel{
    private String title;
    private String description;
    private String firstName;
    private String lastName;

    private enum status{
        OPEN, PENDING, COMPLETED
    }

    @JsonIgnore
    @ManyToOne
    private Users users;
}
