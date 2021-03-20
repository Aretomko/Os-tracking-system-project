package com.example.demo.controllers;

import com.example.demo.domen.Disk;
import com.example.demo.domen.User;
import com.example.demo.domen.rquests.UpdateDiskInfoRequest;
import com.example.demo.repos.DiskRepo;
import com.example.demo.repos.UserRepo;
import com.example.demo.service.IdValidationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DiskController {
    private final DiskRepo diskRepo;
    private final UserRepo userRepo;
    private final IdValidationService idValidationService;

    public DiskController(DiskRepo diskRepo, UserRepo userRepo, IdValidationService idValidationService) {
        this.diskRepo = diskRepo;
        this.userRepo = userRepo;
        this.idValidationService = idValidationService;
    }

    @PostMapping("/setDiskInfo/{userId}")
    public ResponseEntity<String> setDiskInfo(@PathVariable String userId,
                                              @RequestBody UpdateDiskInfoRequest request){
        if(!idValidationService.checkId(userId)) return ResponseEntity.badRequest().body("ERROR");
        User user = userRepo.findById(Long.valueOf(userId)).orElse(null);
        if (user == null ) return ResponseEntity.badRequest().body("ERROR");
        //update
        for (Disk disk: user.getDisks()){
            diskRepo.delete(disk);
        }
        for (Disk disk : request.getDisks()) {
            disk.setUser(user);
            diskRepo.save(disk);
        }
        return ResponseEntity.accepted().body("Updated successfully");
    }
}
