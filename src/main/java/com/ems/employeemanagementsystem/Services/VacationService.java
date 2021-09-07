package com.ems.employeemanagementsystem.Services;

import com.ems.employeemanagementsystem.Models.Users;
import com.ems.employeemanagementsystem.Models.Vacation;
import com.ems.employeemanagementsystem.RequestEntities.VacationRequest;

import java.util.List;

public interface VacationService {
    List<Vacation> getVacationById(Long id);
    List<Vacation> getAllVacation();
    Vacation createVacationRequest(VacationRequest vacationRequest);
    List getVacationByUser(Users users);
}
