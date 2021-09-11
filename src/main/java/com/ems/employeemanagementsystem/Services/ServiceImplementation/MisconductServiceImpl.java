package com.ems.employeemanagementsystem.Services.ServiceImplementation;

import com.ems.employeemanagementsystem.Models.Misconduct;
import com.ems.employeemanagementsystem.Models.Users;
import com.ems.employeemanagementsystem.Repositories.MisconductRepository;
import com.ems.employeemanagementsystem.Repositories.UserRepository;
import com.ems.employeemanagementsystem.RequestEntities.MisconductRequest;
import com.ems.employeemanagementsystem.ResponseBody.ResponseApi;
import com.ems.employeemanagementsystem.Services.MisconductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MisconductServiceImpl implements MisconductService {

    @Autowired
    private MisconductRepository misconductRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public ResponseApi createMisconduct(MisconductRequest misconductRequest, Long id) throws Exception {
        Users users = userRepository.getById(id);
        Misconduct misconduct = new Misconduct();
        ResponseApi response = new ResponseApi();

        misconduct.setFirstName(users.getFirstName());
        misconduct.setLastName(users.getLastName());
        misconduct.setSubject(misconductRequest.getSubject());
        misconduct.setDescription(misconductRequest.getDescription());
        misconduct.setUsers(users);

        var misconductDb = misconductRepository.save(misconduct);

        response.setMessage("Misconduct report created for "+ users.getFirstName()+
                " "+users.getLastName() +"on account of"+ " "+ misconductRequest.getSubject());
        response.setData(misconductDb);

        return response;
    }

    @Override
    public List<Misconduct> listAllMisconducts() {
        return misconductRepository.findAll();
    }

    @Override
    public Misconduct getMisconductById(Long id) {
        return misconductRepository.getById(id);
    }

    @Override
    public List<Misconduct> getMisconductByUsers(Users users) {
        return misconductRepository.findMisconductByUsers(users);
    }
}
