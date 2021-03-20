package com.example.sweater.entities;

import javax.persistence.*;

@Entity
@Table(name = "cpu")
public class CPU {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int cpuNumber;
    private int usedInPercents;
    @OneToOne(mappedBy = "virtualMemory")
    private User user;

    public CPU() {
    }

    public CPU(int cpuNumber, int usedInPercents, User user) {
        this.cpuNumber = cpuNumber;
        this.usedInPercents = usedInPercents;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public int getCpuNumber() {
        return cpuNumber;
    }
    public void setCpuNumber(int cpuNumber) {
        this.cpuNumber = cpuNumber;
    }
    public int getUsedInPercents() {
        return usedInPercents;
    }
    public void setUsedInPercents(int usedInPercents) {
        this.usedInPercents = usedInPercents;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
}
