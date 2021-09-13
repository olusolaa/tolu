package com.ems.employeemanagementsystem.RequestEntities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VacationRequest {
    private String type;
    private enum status{
        APPROVED, DENIED, PENDING
    };
    private String reason;
    private Long duration;
    private String title;
}
