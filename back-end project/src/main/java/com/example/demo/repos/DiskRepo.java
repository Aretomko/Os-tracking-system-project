package com.example.demo.repos;

import com.example.demo.domen.Disk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiskRepo  extends JpaRepository<Disk, Long> {
}
