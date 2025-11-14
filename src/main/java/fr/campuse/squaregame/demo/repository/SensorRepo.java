package fr.campuse.squaregame.demo.repository;

import fr.campuse.squaregame.demo.Controller.SensorController;
import fr.campuse.squaregame.demo.Sensor;

import java.util.ArrayList;

public interface SensorRepo {

    public Sensor getbyID(int ID);
    public void deleteSensor (Sensor sensor);
    public void addSensor(Sensor sensor);
}
