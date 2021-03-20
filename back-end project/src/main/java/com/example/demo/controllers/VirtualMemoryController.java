package com.example.demo.controllers;

import com.example.demo.domen.User;
import com.example.demo.domen.VirtualMemory;
import com.example.demo.domen.rquests.VirtualMemoryUpdateRequest;
import com.example.demo.repos.UserRepo;
import com.example.demo.repos.VirtualMemoryRepo;
import com.example.demo.service.IdValidationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VirtualMemoryController {
    private final UserRepo userRepo;
    private final VirtualMemoryRepo virtualMemoryRepo;
    private final IdValidationService idValidationService;

    public VirtualMemoryController(UserRepo userRepo, VirtualMemoryRepo virtualMemoryRepo, IdValidationService idValidationService) {
        this.userRepo = userRepo;
        this.virtualMemoryRepo = virtualMemoryRepo;
        this.idValidationService = idValidationService;
    }

    @PostMapping("/setVirtualMemory/{userId}")
    public ResponseEntity<String> setVirtualMemory(@PathVariable String userId,
                                                   @RequestBody VirtualMemoryUpdateRequest request) {
        //validation
        if (!idValidationService.checkId(userId)) return ResponseEntity.badRequest().body("ERROR");
        User user = userRepo.findById(Long.valueOf(userId)).orElse(null);
        if (user == null ) return ResponseEntity.badRequest().body("ERROR");
        //update
        if(user.getVirtualMemory() == null){
            VirtualMemory virtualMemory = new VirtualMemory(request.getTotal(), request.getInUse(), user);
            virtualMemoryRepo.save(virtualMemory);
            user.setVirtualMemory(virtualMemory);
            userRepo.save(user);
        }else{
            VirtualMemory virtualMemory = user.getVirtualMemory();
            virtualMemory.setTotal(request.getTotal());
            virtualMemory.setInUse(request.getInUse());
            virtualMemory.setUser(user);
            virtualMemoryRepo.save(virtualMemory);
        }
        //response
        return ResponseEntity.accepted().body("Updated successfully");
    }
}