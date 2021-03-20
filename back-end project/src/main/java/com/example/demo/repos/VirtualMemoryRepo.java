package com.example.demo.repos;

import com.example.demo.domen.VirtualMemory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VirtualMemoryRepo  extends JpaRepository<VirtualMemory, Long> {

}
