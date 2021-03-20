package com.example.demo.domen.rquests;

public class CPUUpdateRequest {
    private int cpuNumber;
    private int usedInPercents;

    public CPUUpdateRequest() {
    }

    public CPUUpdateRequest(int cpuNumber, int usedInPercents) {
        this.cpuNumber = cpuNumber;
        this.usedInPercents = usedInPercents;
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
}
