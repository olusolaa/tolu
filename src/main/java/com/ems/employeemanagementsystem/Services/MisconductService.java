package com.ems.employeemanagementsystem.Services;

import com.ems.employeemanagementsystem.Models.Misconduct;
import com.ems.employeemanagementsystem.RequestEntities.MisconductRequest;

import java.util.List;

public interface MisconductService {
    Misconduct getMisconductById(Long id);
    List<Misconduct> getAllMisconduct();
    List<Misconduct> getMisconductByUser();
    Misconduct createMisconduct(MisconductRequest misconductRequest);

}
