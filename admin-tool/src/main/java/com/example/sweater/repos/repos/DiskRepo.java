package com.example.sweater.repos.repos;


import com.example.sweater.entities.Disk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiskRepo  extends JpaRepository<Disk, Long> {
}
