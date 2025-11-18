package fr.campus.squaregame.demo.repository;

import fr.campus.squaregame.demo.model.sensor.Sensor;

public interface SensorRepo {

    public Sensor getbyID(int ID);
    public void deleteSensor (Sensor sensor);
    public void addSensor(Sensor sensor);
}
