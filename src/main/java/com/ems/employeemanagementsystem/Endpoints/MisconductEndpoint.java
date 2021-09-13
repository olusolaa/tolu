package com.ems.employeemanagementsystem.Endpoints;

import com.ems.employeemanagementsystem.Models.Misconduct;
import com.ems.employeemanagementsystem.Repositories.UserRepository;
import com.ems.employeemanagementsystem.RequestEntities.MisconductRequest;
import com.ems.employeemanagementsystem.ResponseBody.ResponseApi;
import com.ems.employeemanagementsystem.Services.ServiceImplementation.MisconductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
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

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/all")
    public List<Misconduct> getAllMisconducts () {
        List<Misconduct> misconductList = misconductService.listAllMisconducts();
        return misconductList;
    }

    @GetMapping("/{id}")
    public Misconduct getMisconductById (@PathVariable(value = "id") Long misconductId ) {
        return this.misconductService.getMisconductById(misconductId);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/users/{id}")
    public List<Misconduct> getMisconductByUser(@PathVariable Long id) {
        var users = userRepository.findById(id).get();
        return this.misconductService.getMisconductByUsers(users);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/create/{id}")
    public ResponseEntity<ResponseApi> createMisconduct (@RequestBody MisconductRequest misconductRequest, @PathVariable Long id) throws Exception {
        ResponseApi responseApi=  misconductService.createMisconduct(misconductRequest, id);
        return ResponseEntity.status(HttpStatus.OK).body(responseApi);
    }
}
