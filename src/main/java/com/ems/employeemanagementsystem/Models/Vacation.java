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
public class Vacation extends BaseModel{
    private String type;
    private enum status{
        APPROVED, DENIED, PENDING
    };
    private String reason;
    private Long duration;
    private String title;

    @ManyToOne
    private Users users;
}
