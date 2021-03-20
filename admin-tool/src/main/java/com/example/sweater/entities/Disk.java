package com.example.sweater.entities;

import javax.persistence.*;

@Entity
public class Disk {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String total;
    private String used;
    private int usedInPercents;
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    public Disk() {
    }

    public Disk(String name, String total, String used, int usedInPercents, User user) {
        this.name = name;
        this.total = total;
        this.used = used;
        this.usedInPercents = usedInPercents;
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

    public String getUsed() {
        return used;
    }

    public void setUsed(String used) {
        this.used = used;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
