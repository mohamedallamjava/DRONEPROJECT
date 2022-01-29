package com.drones.drones.service;

import com.drones.drones.model.Drone;
import com.drones.drones.payload.request.DroneRequest;
import com.drones.drones.payload.response.DroneResponse;
import com.drones.drones.repository.DroneReposetory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DroneService {
@Autowired
    private DroneReposetory droneReposetory;
public Drone SaveDrone(DroneRequest droneRequest)
{
    Drone drone=new Drone();
    drone.setSeialnumber(droneRequest.getSeialnumber());
    drone.setModel(droneRequest.getModel());
    drone.setState(droneRequest.getState());

    return droneReposetory.save(drone);
}
public List<DroneResponse> findall(Long id)
{
    List<DroneResponse>dres=new ArrayList<>();
    List<Drone> convert=new ArrayList<>();
    try {
        Optional<Drone> drones = droneReposetory.findById(id);
        convert=drones.isPresent()? Collections.singletonList(drones.get()) :Collections.emptyList();
        dres= convert.stream().map(d->new
                DroneResponse(d.getId(),d.getSeialnumber(),d.getModel(),d.getWeight(),d.getBatteryCapacity(),d.getState(),"sucess") ).collect(Collectors.toList());
    }
    catch (Exception e)
    {
        e.printStackTrace();
        System.out.println(e);
    }
    return dres;
}
    public List<DroneResponse> getavailableDrones(String state)
    {
        List<DroneResponse>dres=new ArrayList<>();
        try {
            List<Drone> drones=droneReposetory.findByState(state);

            dres= drones.stream().map(d->new DroneResponse(
                    d.getId(),d.getSeialnumber(),d.getModel(),d.getWeight(),d.getBatteryCapacity(),d.getState(),"sucess"
            ) ).collect(Collectors.toList());

        }
        catch (Exception e)
        {
        e.printStackTrace();
        }
        return dres;
    }
}
