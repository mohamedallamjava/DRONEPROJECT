package com.drones.drones.service;

import com.drones.drones.model.Drone;
import com.drones.drones.model.Medication;
import com.drones.drones.payload.request.DroneRequest;
import com.drones.drones.payload.request.MedicationRequest;
import com.drones.drones.payload.response.MedicalResponse;
import com.drones.drones.repository.DroneReposetory;
import com.drones.drones.repository.MedicationRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MedicationService {
@Autowired
    private MedicationRepository medicationRepository;
@Autowired
    DroneReposetory droneReposetory;
    private static Logger log= LoggerFactory.getLogger("audit");
    public Medication SaveMedication(MedicationRequest medicationRequest,byte[] file)
    {
log.info("start trace");
        Optional<Drone> dr=droneReposetory.findById(medicationRequest.getDroneid());

        Medication medication=new Medication(
              medicationRequest.getName(),
      medicationRequest.getWeight(),
                medicationRequest.getCode(),
                file,
        dr.get()

        );
        log.info("the batter level tracking");
  log.trace("the value of battery for drone"+dr.get().getSeialnumber()+" brfore loading is "+dr.get().getBatteryCapacity().toString(),dr.get().getWeight());
        Double availableWeight=dr.get().getWeight()-medicationRequest.getWeight();
         Double availbleBateryCapacty=(dr.get().getBatteryCapacity()-25.00)*1/100;

        dr.get().setState("LOADING");
        dr.get().setWeight(availableWeight);
        dr.get().setBatteryCapacity(availbleBateryCapacty);

        Drone drone=droneReposetory.save(dr.get());
Medication md=medicationRepository.save(medication);
log.info("the value of battery after loading is "+dr.get().getBatteryCapacity());
        return md;
    }
public MedicationRequest toJson(String medcationReq)
{
    MedicationRequest medcationJson=new MedicationRequest();
    try {
        ObjectMapper objectMapper=new ObjectMapper();
        medcationJson=objectMapper.readValue(medcationReq,MedicationRequest.class);

    }
    catch (IOException err)
    {
        err.printStackTrace();
    }
    return medcationJson;
}
public List<MedicalResponse>findByDronId(String droneid)
{
     List<Medication> md=medicationRepository.FindByDroneId(Long.parseLong(droneid));
       List<MedicalResponse> mr=md.stream().map(m-> new MedicalResponse(m.getId(),m.getName(),m.getWeight(),m.getCode(),m.getImage(),m.getDrone())).collect(Collectors.toList());
    return mr;
}
}
