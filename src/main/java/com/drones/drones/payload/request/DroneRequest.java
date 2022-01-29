package com.drones.drones.payload.request;

import javax.persistence.Column;

public class DroneRequest {


    private String seialnumber;
    private String model;
    private Double weight;

    private String state;

    public String getSeialnumber() {
        return seialnumber;
    }

    public void setSeialnumber(String seialnumber) {
        this.seialnumber = seialnumber;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public DroneRequest(String seialnumber, String model, Double weight, String state) {
        this.seialnumber = seialnumber;
        this.model = model;
        this.weight = weight;
        this.state = state;
    }
}
