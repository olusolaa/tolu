package com.ems.employeemanagementsystem.Endpoints;

import com.ems.employeemanagementsystem.Models.Misconduct;
import com.ems.employeemanagementsystem.Models.Payroll;
import com.ems.employeemanagementsystem.Models.Users;
import com.ems.employeemanagementsystem.Repositories.PayrollRepository;
import com.ems.employeemanagementsystem.Repositories.UserRepository;
import com.ems.employeemanagementsystem.RequestEntities.PayrollRequest;
import com.ems.employeemanagementsystem.ResponseBody.ResponseApi;
import com.ems.employeemanagementsystem.Services.ServiceImplementation.PayrollServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/payroll")
public class PayrollEndPoints {

    @Autowired
    private PayrollServiceImpl payrollService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/create/{id}")
    public ResponseEntity<ResponseApi> createPayrollRecord (@RequestBody PayrollRequest payrollRequest, @PathVariable Long id) throws Exception {
        ResponseApi responseApi=  payrollService.createPayrollRecord(payrollRequest, id);
        return ResponseEntity.status(HttpStatus.OK).body(responseApi);
    }

    @RequestMapping("/all")
    public List<Payroll> getAllPayroll () {
        List<Payroll> payrollList = payrollService.listAllPayroll();
        return payrollList;
    }

    @RequestMapping("/{id}")
    public Payroll getPayrollById (@PathVariable(value = "id") Long payrollId ) {
        return this.payrollService.getPayrollById(payrollId);
    }

    @RequestMapping("/users/{id}")
    public List<Payroll> getPayrollByUser(@PathVariable Long id) {
        Users users = userRepository.getById(id);
        return this.payrollService.getPayrollByUsers(users);
    }
}
