package com.ems.employeemanagementsystem.Endpoints;

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

@RestController
@RequestMapping("/payroll")
public class PayrollEndPoints {

    @Autowired
    private PayrollServiceImpl payrollService;

    @PostMapping("/create/{id}")
    public ResponseEntity<ResponseApi> createPayrollRecord (@RequestBody PayrollRequest payrollRequest, @PathVariable Long id) throws Exception {
        ResponseApi responseApi=  payrollService.createPayrollRecord(payrollRequest, id);
        return ResponseEntity.status(HttpStatus.OK).body(responseApi);
    }
}
