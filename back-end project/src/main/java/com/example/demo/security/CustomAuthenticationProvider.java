package com.example.demo.security;


import com.example.demo.domen.Role;
import com.example.demo.domen.User;
import com.example.demo.repos.UserRepo;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Set;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private final UserRepo userRepo;

    public CustomAuthenticationProvider(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getPrincipal() + "";
        String password = authentication.getCredentials() + "";

        User user = userRepo.findByUsername(username);
        if (user == null) {
            throw new BadCredentialsException("User with such username does not exist");
        }
        String  userPasswordTest = user.getPassword();
        if (!userPasswordTest.equals(password)) {
            throw new BadCredentialsException("Incorrect password");
        }
//        if (!user.isActive()){
//            throw new UserIsNotActivatedException("User is not activated");
//        }
        Set<Role> userRights = null;
        try {
            userRights = (Set<Role>) Collections.singleton(Role.parseRoleFromString("USER"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(username,password, userRights);
        return usernamePasswordAuthenticationToken;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}