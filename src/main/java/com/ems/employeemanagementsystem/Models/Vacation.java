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
public class Vacation extends BaseModel{
    private String type;
    private enum status{
        APPROVED, DENIED, PENDING
    };
    private String reason;
    private Long duration;
    private String title;

    @JsonIgnore
    @ManyToOne
    private Users users;
}
