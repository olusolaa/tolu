package com.ems.employeemanagementsystem.Services;

import com.ems.employeemanagementsystem.Models.Misconduct;
import com.ems.employeemanagementsystem.Models.Users;
import com.ems.employeemanagementsystem.RequestEntities.MisconductRequest;
import com.ems.employeemanagementsystem.ResponseBody.ResponseApi;

import java.util.List;

public interface MisconductService {
    ResponseApi createMisconduct(MisconductRequest misconductRequest, Long id) throws Exception;
    List<Misconduct> listAllMisconducts();
    Misconduct getMisconductById(Long id);
    List<Misconduct> getMisconductByUsers(Users users);
}
