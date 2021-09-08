package com.ems.employeemanagementsystem.Services.ServiceImplementation;

import com.ems.employeemanagementsystem.Models.Users;
import com.ems.employeemanagementsystem.Models.Vacation;
import com.ems.employeemanagementsystem.Repositories.VacationRepository;
import com.ems.employeemanagementsystem.RequestEntities.VacationRequest;
import com.ems.employeemanagementsystem.Services.VacationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VacationServiceImpl implements VacationService {

    @Autowired
    private VacationRepository vacationRepository;

    @Override
    public List<Vacation> getVacationById(Long id) {
        return null;
    }

    @Override
    public List<Vacation> getAllVacation() {
        return null;
    }

    @Override
    public Vacation createVacationRequest(VacationRequest vacationRequest) {
        return null;
    }

    @Override
    public List getVacationByUser(Users users) {
        return null;
    }
}
