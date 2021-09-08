package com.ems.employeemanagementsystem.Services.ServiceImplementation;

import com.ems.employeemanagementsystem.Models.Misconduct;
import com.ems.employeemanagementsystem.Repositories.MisconductRepository;
import com.ems.employeemanagementsystem.RequestEntities.MisconductRequest;
import com.ems.employeemanagementsystem.Services.MisconductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MisconductServiceImpl implements MisconductService {

    @Autowired
    private MisconductRepository misconductRepository;

    @Override
    public Misconduct getMisconductById(Long id) {
        return null;
    }

    @Override
    public List<Misconduct> getAllMisconduct() {
        return null;
    }

    @Override
    public List<Misconduct> getMisconductByUser() {
        return null;
    }

    @Override
    public Misconduct createMisconduct(MisconductRequest misconductRequest) {
        return null;
    }
}
