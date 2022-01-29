package com.drones.drones.payload.response;

import com.drones.drones.model.Drone;

import javax.persistence.*;

public class MedicalResponse {
    private Integer id;
    private String name;
    private Double weight;
    private String code;
    private byte[] image;
    private Drone drone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Drone getDrone() {
        return drone;
    }

    public void setDrone(Drone drone) {
        this.drone = drone;
    }
public MedicalResponse(){}

    public MedicalResponse(Integer id, String name, Double weight, String code, byte[] image, Drone drone) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.code = code;
        this.image = image;
        this.drone = drone;
    }
}
