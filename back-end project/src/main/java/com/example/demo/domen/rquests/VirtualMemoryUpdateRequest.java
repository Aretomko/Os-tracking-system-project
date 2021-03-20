package com.example.demo.domen.rquests;

public class VirtualMemoryUpdateRequest {
    private String total;
    private String inUse;

    public VirtualMemoryUpdateRequest() {
    }

    public VirtualMemoryUpdateRequest(String total, String inUse) {
        this.total = total;
        this.inUse = inUse;
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
}
