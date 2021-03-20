package com.example.sweater.entities;

import javax.persistence.*;

@Entity
@Table(name = "ram")
public class VirtualMemory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String total;
    private String inUse;
    @OneToOne(mappedBy = "virtualMemory")
    private User user;

    public VirtualMemory() {
    }

    public VirtualMemory(String total, String inUse, User user) {
        this.total = total;
        this.inUse = inUse;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getInUse() {
        return inUse;
    }

    public void setInUse(String inUse) {
        this.inUse = inUse;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
