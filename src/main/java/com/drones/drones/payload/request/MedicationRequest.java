package com.drones.drones.payload.request;

import com.drones.drones.model.Drone;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.aspectj.bridge.Message;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MedicationRequest {


    private String name;
    private Double weight;
    private String code;
    private Long droneid;

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



    public Long getDroneid() {
        return droneid;
    }

    public void setDroneid(Long droneid) {
        this.droneid = droneid;
    }
}
