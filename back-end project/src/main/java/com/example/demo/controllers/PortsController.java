package com.example.demo.controllers;

import com.example.demo.domen.User;
import com.example.demo.domen.rquests.PortsUpdateRequest;
import com.example.demo.repos.UserRepo;
import com.example.demo.service.IdValidationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PortsController {
    private final UserRepo userRepo;
    private final IdValidationService idValidationService;

    public PortsController(UserRepo userRepo, IdValidationService idValidationService) {
        this.userRepo = userRepo;
        this.idValidationService = idValidationService;
    }
    @PostMapping("/setOpenPorts/{userId}")
    public ResponseEntity<String> setPorts(@PathVariable String userId,
                                           @RequestBody PortsUpdateRequest request){
        if(!idValidationService.checkId(userId)) return ResponseEntity.badRequest().body("ERROR");
        User user = userRepo.findById(Long.valueOf(userId)).orElse(null);
        if (user == null ) return ResponseEntity.badRequest().body("ERROR");
        //update
        user.setPorts(request.getPorts());
        userRepo.save(user);
        return ResponseEntity.accepted().body("Updated successfully");
    }
}
