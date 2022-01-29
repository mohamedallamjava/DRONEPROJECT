package com.drones.drones.manager;

import com.drones.drones.model.Drone;
import com.drones.drones.payload.request.DroneRequest;
import com.drones.drones.payload.response.DroneResponse;
import com.drones.drones.service.DroneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DroneManager {
@Autowired
    private DroneService droneService;
public List<DroneResponse> getavailableDrones(String state)
{
    return  droneService.getavailableDrones(state);
}
public List<DroneResponse> getAllDrones(Long id)
{
    return droneService.findall(id);
}
public boolean SaveDrone(DroneRequest droneRequest)
{
    boolean state=false;
    try {
        Drone drone=droneService.SaveDrone(droneRequest);
        if(drone!=null)
            state =true;
    }
    catch (Exception e)
    {
        e.printStackTrace();
    }
    return state;
}
}
