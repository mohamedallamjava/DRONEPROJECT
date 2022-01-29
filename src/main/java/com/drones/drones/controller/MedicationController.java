package com.drones.drones.controller;

import com.drones.drones.manager.medicationManager;
import com.drones.drones.model.Drone;
import com.drones.drones.model.Medication;
import com.drones.drones.payload.request.MedicationRequest;
import com.drones.drones.payload.response.DroneResponse;
import com.drones.drones.payload.response.MedicalResponse;
import com.drones.drones.payload.response.ResponseMessage;
import com.drones.drones.service.MedicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/medications")
public class MedicationController {

@Autowired
   private medicationManager medicationManager;
    @PostMapping (value = "/addmedication",consumes = {MediaType.APPLICATION_JSON_VALUE,
                                                   MediaType.MULTIPART_FORM_DATA_VALUE})
        public ResponseEntity<ResponseMessage> addMedication(@RequestParam("file") MultipartFile file, @RequestPart("md") String medicationRequest)
{
    String message = "";
    try {
         MedicationRequest medicationRequest1=medicationManager.toJson(medicationRequest);
         byte[] arr = new byte[file.getBytes().length];
        if(medicationManager.BattaeryAvailbilty(medicationRequest1.getDroneid()))
             message="the battery is bellow 25%";
         else {
             boolean medicationResponse = medicationManager.SaveMedication(medicationRequest1, arr);
             if (medicationResponse ) {
                 message = "medecal item  register sucessfully  ";
             } else {
                 message = "error";
             }
         }
        return     ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));

    }
    catch(Exception e){
        if (e.toString().contains("the weight must not be greater than 500"))
        message="the weight must not be greater than 500";
        else if (e.toString().contains("the item name must be charters ,numbers,_-"))
            message="the item name must be charters ,numbers,_-";
          else if(e.toString().contains("the item code must be charters ,numbers,_-"))
              message="the item code must be charters ,numbers,_-";
            else message = "Could not register medical item: " +e+"!";
        System.out.println(e.toString());
        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
    }
}
    @GetMapping(value="/getMedcation" ,produces = "application/json;charset=UTF-8")
    public ResponseEntity<List<MedicalResponse>> GetMedical(@RequestParam("id") String droneId) {
        String message = "";
        List<MedicalResponse>medres=new ArrayList<>();
        try {
            List<MedicalResponse> medications=medicationManager.getallmedcation(droneId);
            return ResponseEntity.status(HttpStatus.OK).body(medres);
        } catch (Exception e) {
            message = "there is problem " +e+"!";

            System.out.println(e.toString());
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(medres);
        }
    }
}
