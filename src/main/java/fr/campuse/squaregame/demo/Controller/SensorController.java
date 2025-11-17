package fr.campuse.squaregame.demo.Controller;

import fr.campuse.squaregame.demo.RandomHeartbeat;
import fr.campuse.squaregame.demo.Sensor;
import fr.campuse.squaregame.demo.Services.SensorService;
import fr.campuse.squaregame.demo.repository.SensorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
public class SensorController{

    @Autowired
    SensorService services;


    @PutMapping("/heartbeats/put/{id}")
    public void setIdbyID(@PathVariable("id") int ID)
    {
        Random rand = new Random();
        this.services.getbyID(ID).setID(ID);
    }

    @GetMapping("/heartbeats/{id}")
    public int getbyID(@PathVariable("id") int ID) {
        return this.services.getbyID(ID).getID();
    }

    @DeleteMapping("/heartbeats/delete/{id}")
    public void deleteSensor(@PathVariable("id") int ID)
    {
        Sensor sensor = this.services.getbyID(ID);
        this.services.deleteSensor(sensor);
    }

    @PostMapping("/heartbeats/post/{id}")
    public void PostSensor(@PathVariable("id") int ID)
    {
        Sensor sensor = new RandomHeartbeat(new Random());
        this.services.addSensor(sensor);
    }


}
