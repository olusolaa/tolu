package com.ems.employeemanagementsystem.Endpoints;

import com.ems.employeemanagementsystem.Models.Expense;
import com.ems.employeemanagementsystem.Models.Misconduct;
import com.ems.employeemanagementsystem.Models.Users;
import com.ems.employeemanagementsystem.Repositories.UserRepository;
import com.ems.employeemanagementsystem.RequestEntities.ExpenseRequest;
import com.ems.employeemanagementsystem.RequestEntities.MisconductRequest;
import com.ems.employeemanagementsystem.ResponseBody.ResponseApi;
import com.ems.employeemanagementsystem.Services.ServiceImplementation.ExpenseServiceImpl;
import com.ems.employeemanagementsystem.Services.ServiceImplementation.MisconductServiceImpl;
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
@RequestMapping("/misconduct")
public class MisconductEndpoint {

    @Autowired
    private MisconductServiceImpl misconductService;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/all")
    public List<Misconduct> getAllMisconducts () {
        List<Misconduct> misconductList = misconductService.listAllMisconducts();
        return misconductList;
    }

    @RequestMapping("/{id}")
    public Misconduct getMisconductById (@PathVariable(value = "id") Long misconductId ) {
        return this.misconductService.getMisconductById(misconductId);
    }

    @RequestMapping("/users/{id}")
    public List<Misconduct> getMisconductByUser(@PathVariable Long id) {
        Users users = userRepository.getById(id);
        return this.misconductService.getMisconductByUsers(users);
    }

    @PostMapping("/create/{id}")
    public ResponseEntity<ResponseApi> createExpense (@RequestBody MisconductRequest misconductRequest, @PathVariable Long id) throws Exception {
        ResponseApi responseApi=  misconductService.createMisconduct(misconductRequest, id);
        return ResponseEntity.status(HttpStatus.OK).body(responseApi);
    }
}
