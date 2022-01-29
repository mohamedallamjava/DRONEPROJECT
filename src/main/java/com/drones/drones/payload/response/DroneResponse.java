package com.drones.drones.payload.response;

public class DroneResponse {

    private Long id;
    private String seialnumber;
    private String model;
    private Double weight;
    private Double batteryCapacity;
    private String state;
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Double getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(Double batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public DroneResponse(Long id, String seialnumber, String model, Double weight, Double batteryCapacity, String state, String message) {
        this.id = id;
        this.seialnumber = seialnumber;
        this.model = model;
        this.weight = weight;
        this.batteryCapacity = batteryCapacity;
        this.state = state;
        this.message = message;
    }

    public  DroneResponse(){}
}
