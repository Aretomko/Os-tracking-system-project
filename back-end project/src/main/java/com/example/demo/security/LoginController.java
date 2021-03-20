package com.example.demo.security;

import com.example.demo.domen.User;
import com.example.demo.domen.rquests.AuthenticationRequest;
import com.example.demo.repos.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import static org.springframework.http.ResponseEntity.ok;

@RestController
public class LoginController {
    @Autowired
    CustomAuthenticationProvider authenticationManager;
    @Autowired
    JwtTokenProvider jwtTokenProvider;
    @Autowired
    UserRepo userRepo;


    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);


//    @PostMapping("/login")
//    public ResponseEntity login(@RequestBody AuthenticationRequest data) {
//        String username = data.getUsername();
//        UsernamePasswordAuthenticationToken tokenObject = new UsernamePasswordAuthenticationToken(username, data.getPassword());
//        authenticationManager.authenticate(tokenObject);
//        String token = jwtTokenProvider.createToken(username, new ArrayList<String>(Collections.singleton("USER")));
//        HashMap<Object, Object> model = new HashMap<>();
//        model.put("username", username);
//        model.put("token", token);
//        logger.info("User" + username + "has logged into the application");
//        return ok(model);
//    }
    @GetMapping("/checkUserCredentials/{username}/{password}")
    public ResponseEntity<String> checkUserCredentials(@PathVariable String username,
                                                       @PathVariable String password){
        User user = userRepo.findByUsername(username);
        if(user == null) return ResponseEntity.badRequest().body("ERROR");

        if (user.getPassword().equals(password)) {
            return ResponseEntity.accepted().body("Updated successfully");
        } else {
            return ResponseEntity.badRequest().body("ERROR");
        }
    }

}
