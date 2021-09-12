package com.ems.employeemanagementsystem.Services.ServiceImplementation;

import com.ems.employeemanagementsystem.Models.Users;
import com.ems.employeemanagementsystem.Models.Vacation;
import com.ems.employeemanagementsystem.Repositories.UserRepository;
import com.ems.employeemanagementsystem.Repositories.VacationRepository;
import com.ems.employeemanagementsystem.RequestEntities.VacationRequest;
import com.ems.employeemanagementsystem.ResponseBody.ResponseApi;
import com.ems.employeemanagementsystem.Services.VacationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import java.util.List;

@Service
public class VacationServiceImpl implements VacationService {

    @Autowired
    private VacationRepository vacationRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Vacation getVacationById(Long id) {
        return vacationRepository.getById(id);
    }

    @Override
    public List<Vacation> listAllVacation() {
        return vacationRepository.findAll();
    }

    @Override
    public ResponseApi createVacationRequest(VacationRequest vacationRequest, Long id) {
        Users users = userRepository.getById(id);
        Vacation vacation = new Vacation();
        var response = new  ResponseApi();

        vacation.setTitle(vacationRequest.getTitle());
        vacation.setDuration(vacationRequest.getDuration());
        vacation.setReason(vacationRequest.getReason());
        vacation.setUsers(users);

        var vacationDb = vacationRepository.save(vacation);
        response.setMessage("Your vacation Request titled " +vacationRequest.getTitle()+
                " "+ vacationRequest.getDuration()+ " days has been created");
        response.setData(vacationDb);

        return response;
    }

    @Override
    public List getVacationByUser(Users users) {

        return vacationRepository.findAllByUsers(users);
    }
}
