package com.example.demo.domen.rquests;

public class PortsUpdateRequest {
    private String ports;

    public PortsUpdateRequest(String ports) {
        this.ports = ports;
    }

    public PortsUpdateRequest() {
    }

    public String getPorts() {
        return ports;
    }

    public void setPorts(String ports) {
        this.ports = ports;
    }
}
