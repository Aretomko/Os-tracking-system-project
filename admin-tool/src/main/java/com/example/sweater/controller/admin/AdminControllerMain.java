package com.example.sweater.controller.admin;

import com.example.sweater.entities.Disk;
import com.example.sweater.entities.User;
import com.example.sweater.repos.repos.UserRepo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
public class AdminControllerMain {
    private final UserRepo userRepo;

    public AdminControllerMain(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping("/admin")
    private String getAdminPage(Map<String, Object> model){
        List<User> users = userRepo.findAll();
        model.put("users" ,users);
        return "admin";
    }
    @GetMapping("/seeDiskInfo/{userId}")
    public String getDiskInfo(@PathVariable String userId,
                              Map<String, Object> model){
        User user = userRepo.findById(Long.valueOf(userId)).get();
        List<Disk> disks =  user.getDisks();
        model.put("disks", disks);
        model.put("username", user.getUsername());
        return "disks";
    }
    @GetMapping("/seeOpenPorts/{userId}")
    public String openPorts(@PathVariable String userId,
                            Map<String, Object> model){
        User user = userRepo.findById(Long.valueOf(userId)).get();
        List<String> ports = Arrays.asList(user.getPorts().split(","));
        model.put("ports", ports);
        model.put("username", user.getUsername());
        return "ports";
    }
}
