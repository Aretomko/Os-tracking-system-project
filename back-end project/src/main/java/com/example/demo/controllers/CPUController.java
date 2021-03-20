package com.example.demo.controllers;

import com.example.demo.domen.CPU;
import com.example.demo.domen.User;
import com.example.demo.domen.rquests.CPUUpdateRequest;
import com.example.demo.repos.CPURepo;
import com.example.demo.repos.UserRepo;
import com.example.demo.service.IdValidationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CPUController {
    private final CPURepo cpuRepo;
    private final UserRepo userRepo;
    private final IdValidationService idValidationService;

    public CPUController(CPURepo cpuRepo, UserRepo userRepo, IdValidationService idValidationService) {
        this.cpuRepo = cpuRepo;
        this.userRepo = userRepo;
        this.idValidationService = idValidationService;
    }

    @PostMapping("/setCPUInfoMemory/{userId}")
    public ResponseEntity<String> setCPUInfo(@PathVariable String userId,
                                             @RequestBody CPUUpdateRequest request){
        //validation
        if(!idValidationService.checkId(userId)) return ResponseEntity.badRequest().body("ERROR");
        User user = userRepo.findById(Long.valueOf(userId)).orElse(null);
        if (user == null ) return ResponseEntity.badRequest().body("ERROR");
        //update
        if (user.getCpu() == null){
            CPU cpu = new CPU(request.getCpuNumber(), request.getUsedInPercents(), user);
            cpuRepo.save(cpu);
            user.setCpu(cpu);
            userRepo.save(user);
        }else{
            CPU cpu = user.getCpu();
            cpu.setCpuNumber(request.getCpuNumber());
            cpu.setUsedInPercents(request.getUsedInPercents());
            cpu.setUser(user);
            cpuRepo.save(cpu);
        }
        return ResponseEntity.accepted().body("Updated successfully");
    }
}
