package com.example.demo.domen.rquests;

import com.example.demo.domen.Disk;

import java.util.List;

public class UpdateDiskInfoRequest {
    List<Disk> disks;

    public UpdateDiskInfoRequest() {
    }

    public UpdateDiskInfoRequest(List<Disk> disks) {
        this.disks = disks;
    }

    public List<Disk> getDisks() {
        return disks;
    }

    public void setDisks(List<Disk> disks) {
        this.disks = disks;
    }
}
