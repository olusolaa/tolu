package com.ems.employeemanagementsystem.Services;

import com.ems.employeemanagementsystem.Models.Users;
import com.ems.employeemanagementsystem.Models.Vacation;
import com.ems.employeemanagementsystem.RequestEntities.VacationRequest;
import com.ems.employeemanagementsystem.ResponseBody.ResponseApi;

import java.util.List;
import java.util.Optional;

public interface VacationService {
    Optional<Vacation> getVacationById(Long id);
    List<Vacation> listAllVacation();
    ResponseApi createVacationRequest(VacationRequest vacationRequest, Long id) throws Exception;
    List getVacationByUser(Users users);
}
