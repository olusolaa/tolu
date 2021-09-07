package com.ems.employeemanagementsystem.RequestEntities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskRequest {
    private String title;
    private String description;
    private enum status{
        OPEN, PENDING, COMPLETED
    }
}
