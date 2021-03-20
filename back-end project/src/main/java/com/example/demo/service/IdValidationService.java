package com.example.demo.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class IdValidationService {
    public boolean checkId(String id){
        try{
        long num = Long.valueOf(id);
        }catch (Exception ex){
            return false;
        }
       return true;
    }
}
