package com.drones.drones.manager;

import com.drones.drones.model.Drone;
import com.drones.drones.model.Medication;
import com.drones.drones.payload.request.MedicationRequest;
import com.drones.drones.payload.response.MedicalResponse;
import com.drones.drones.repository.DroneReposetory;
import com.drones.drones.service.MedicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class medicationManager {
    @Autowired
     private DroneReposetory droneReposetory;
 @Autowired
 private  MedicationService medicationService;
    public boolean  DroneAvailbilty(Long id)
 { boolean state=false;
     Optional<Drone> dr=droneReposetory.findById(id);
     if(dr.get().getState().contains("IDLE"))
         return true;
     return state;
 }
    public boolean  BattaeryAvailbilty(Long id)
    { boolean state=false;
        Optional<Drone> dr=droneReposetory.findById(id);
        Double battery=dr.get().getBatteryCapacity();
        if(battery<0.025)
            return true;
        return state;
    }
public List<MedicalResponse> getallmedcation(String id)
{
    List<MedicalResponse>medres=new ArrayList<>();
    try {
        List<MedicalResponse> medications= medicationService.findByDronId(id);


    } catch (Exception e) {

        System.out.println(e.toString());

    }
    return medres;
}
public boolean SaveMedication(MedicationRequest medicationRequest,byte[] file)
{
    boolean state=false;
    Medication m=medicationService.SaveMedication(medicationRequest,file);
if(m!=null)
    state=true;
return state;
}
public MedicationRequest toJson(String medreq)
{
    return  medicationService.toJson(medreq);
}
}
