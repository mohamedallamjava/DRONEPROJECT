package com.drones.drones.repository;

import com.drones.drones.model.Drone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DroneReposetory extends JpaRepository<Drone,Long> {
List<Drone>findByState(String state);

}
