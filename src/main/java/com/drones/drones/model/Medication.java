package com.drones.drones.model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@NamedQueries({@NamedQuery(name = "Medication.FindByDroneId",query = "select m from Medication m where m.drone.id=:droneId")})
@Entity
@Table(name = "medications")
public class Medication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Pattern(regexp = "^[a-zA-Z0-9_-]*$",message = "the item name must be charters ,numbers,_-")
    @Column(name = "name")
    private String name;

    @Column(name = "weight")
    @NotNull
    @Max(value = 500,message = "the weight must not be greater than 500")
    private Double weight;

    @Column(name = "code", length = 30)
    @Pattern(regexp = "^[a-zA-Z0-9_-]*$",message = "the item code must be charters ,numbers,_-")
    private String code;
   @Lob
    @Column(name = "image")
    private byte[] image;

    @ManyToOne
    @JoinColumn(name = "drone_id")
    private Drone drone;

    public Drone getDrone() {
        return drone;
    }

    public void setDrone(Drone drone) {
        this.drone = drone;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Medication(String name, Double weight, String code, byte[] image, Drone drone) {
        this.name = name;
        this.weight = weight;
        this.code = code;
        this.image = image;
        this.drone = drone;
    }
    public Medication()
    {}
}