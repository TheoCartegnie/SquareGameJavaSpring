package fr.campuse.squaregame.demo.Services;

import fr.campuse.squaregame.demo.Controller.SensorController;
import fr.campuse.squaregame.demo.RandomHeartbeat;
import fr.campuse.squaregame.demo.Sensor;
import fr.campuse.squaregame.demo.repository.SensorRepo;
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
        controller.remove(sensor);
    }

    @Override
    public void addSensor(Sensor sensor)
    {
        controller.add(sensor);
    }
}
