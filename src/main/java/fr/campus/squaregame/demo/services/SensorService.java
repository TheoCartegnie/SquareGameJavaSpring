package fr.campus.squaregame.demo.services;

import fr.campus.squaregame.demo.model.sensor.RandomHeartbeat;
import fr.campus.squaregame.demo.model.sensor.Sensor;
import fr.campus.squaregame.demo.repository.SensorRepo;
import fr.campus.squaregame.demo.exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Random;


@Service
public class SensorService implements SensorRepo {

    ArrayList<Sensor> controller = new ArrayList<>();
    @Autowired
    public SensorService()
    {
        Random rand = new Random();
        for(int i = 0; i < 50;i++) {
            controller.add(new RandomHeartbeat(new Random()));
            controller.get(i).setID(rand.nextInt(rand.nextInt(50,1000),rand.nextInt(1001,300000)));
        }
    }

    @Override
    public Sensor getbyID(int ID) {

        return controller.get(ID);
    }

    @Override
    public void deleteSensor(Sensor sensor)
    {
        try {
            controller.remove(sensor);
        }
        catch (ProductNotFoundException e)
        {
            System.out.println("The item does not exist in the list.");
        }
    }

    @Override
    public void addSensor(Sensor sensor)
    {
        controller.add(sensor);
    }
}
