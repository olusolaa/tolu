package com.ems.employeemanagementsystem.Services.ServiceImplementation;

import com.ems.employeemanagementsystem.Exceptions.ResourceNotFoundException;
import com.ems.employeemanagementsystem.Models.Expense;
import com.ems.employeemanagementsystem.Models.Payroll;
import com.ems.employeemanagementsystem.Models.Users;
import com.ems.employeemanagementsystem.Repositories.PayrollRepository;
import com.ems.employeemanagementsystem.Repositories.UserRepository;
import com.ems.employeemanagementsystem.RequestEntities.PayrollRequest;
import com.ems.employeemanagementsystem.ResponseBody.ResponseApi;
import com.ems.employeemanagementsystem.Services.PayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Calendar;
import java.util.List;

@Service
public class PayrollServiceImpl implements PayrollService {

    @Autowired
    private PayrollRepository payrollRepository;

    @Autowired
    private UserRepository userRepository;



    @Override
    public ResponseApi createPayrollRecord(PayrollRequest payrollRequest, Long id) throws Exception {
        var monthName = new String[]{"January", "February",
                "March", "April", "May", "June", "July",
                "August", "September", "October", "November",
                "December"};

        var cal = Calendar.getInstance();
        String month = monthName[cal.get(Calendar.MONTH)];

        var payroll = new Payroll();
        var users = userRepository.getById(id);

        var response = new ResponseApi();

        if (payrollRequest.getAmount()<=0) {
            response.setMessage("Invalid figure Supplied");
            return response;
        }

        payroll.setFirstName(users.getFirstName());
        payroll.setLastName(users.getLastName());
        payroll.setMonth(month);
        payroll.setDescription(payrollRequest.getDescription());
        payroll.setAmount(payrollRequest.getAmount());
        payroll.setUsers(users);

        var payrollDb = payrollRepository.save(payroll);
        response.setMessage("Payroll Record tagged "+ month +" " +payrollRequest.getDescription()+
                " " + "for user " + users.getFirstName()+" "+ users.getLastName()+
                " has been created successfully");
        response.setData(payrollDb);
        return response;
    }

    @Override
    public List<Payroll> listAllPayroll() {
        return payrollRepository.findAll();
    }

    @Override
    public Payroll getPayrollById(@PathVariable(value = "id") Long payrollId) {
       return this.payrollRepository.findById(payrollId).
               orElseThrow(()-> new ResourceNotFoundException("Payroll with ID" + payrollId +" not found"));
    }

    @Override
    public List<Payroll> getPayrollByUsers(Users users) {
        return payrollRepository.findAllByUsers(users);
    }
}
