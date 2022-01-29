package com.drones.drones.model;

import javax.persistence.*;
import javax.validation.constraints.Max;

@Entity
@Table(name = "drones")
public class Drone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "seialnumber", length = 100)
    private String seialnumber;

    @Column(name = "model", length = 30)
    private String model;

    @Column(name = "weight",columnDefinition="double precision default '96'")
    private Double weight=500.00;

    @Column(name = "battery_capacity" )
    private Double batteryCapacity=100.00;

    @Column(name = "state", length = 30)
    private String state="IDLE";

    @Column(name = "available_weight")
    private Double availableWeight;

    public Double getAvailableWeight() {
        return availableWeight;
    }

    public void setAvailableWeight(Double availableWeight) {
        this.availableWeight = availableWeight;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Double getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(Double batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSeialnumber() {
        return seialnumber;
    }

    public void setSeialnumber(String seialnumber) {
        this.seialnumber = seialnumber;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}