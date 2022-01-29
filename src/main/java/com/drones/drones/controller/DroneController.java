package com.drones.drones.controller;

import com.drones.drones.manager.DroneManager;
import com.drones.drones.model.Drone;
import com.drones.drones.payload.request.DroneRequest;
import com.drones.drones.payload.response.DroneResponse;
import com.drones.drones.payload.response.ResponseMessage;
import com.drones.drones.service.DroneService;
import jdk.nashorn.internal.ir.CatchNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/drones")
public class DroneController {

@Autowired
private DroneManager droneManager;
@PostMapping("/adddrone")
    public ResponseEntity<ResponseMessage>addDrone(@RequestBody DroneRequest droneRequest)
{  String message = "";
try {
    boolean droneResponse=false;
    droneResponse=droneManager.SaveDrone(droneRequest);
    if(droneResponse)
    {
        message = "drone register sucessfully  " ;
    }
    else
    {
        message="error";
    }
    return     ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));

}
catch(Exception e){

    message = "Could not register drone: " +e+"!";
    System.out.println(e.toString());
    return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
}

}
    @GetMapping(value="/getdrones" ,produces = "application/json;charset=UTF-8")
    public ResponseEntity<List<DroneResponse>> getdrones(@RequestParam("id") Long id) {
        String message = "";

        List<DroneResponse>dres=new ArrayList<>();
       try{
           dres=droneManager.getAllDrones(id);
            return ResponseEntity.status(HttpStatus.OK).body(dres);
        } catch (Exception e) {
            message = "there is problem " +e+"!";
            dres.get(0).setMessage(message);
            System.out.println(e.toString());
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(dres);
        }
    }
    @GetMapping(value="/getavailabledrones" ,produces = "application/json;charset=UTF-8")
    public ResponseEntity<List<DroneResponse>> getavailableDrones(@RequestParam("state") String state) {
        String message = "";
        List<DroneResponse>dres=new ArrayList<>();
        try{

            dres= droneManager.getavailableDrones(state);



        } catch (Exception e) {
            message = "there is problem " +e+"!";
       dres.get(0).setMessage("there is problem");
            System.out.println(e.toString());
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(dres);
        }
        return ResponseEntity.status(HttpStatus.OK).body(dres);
}

}
