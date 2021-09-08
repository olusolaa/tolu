package com.ems.employeemanagementsystem.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
public class Roles extends BaseModel{
    private UserEnum userEnum;
}
