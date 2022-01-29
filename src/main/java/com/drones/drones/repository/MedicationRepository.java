package com.drones.drones.repository;

import com.drones.drones.model.Medication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicationRepository extends JpaRepository<Medication,Long> {

    List<Medication> FindByDroneId(Long droneId);
}
