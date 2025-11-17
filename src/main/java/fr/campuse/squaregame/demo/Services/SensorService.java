package fr.campuse.squaregame.demo.Services;

import fr.campuse.squaregame.demo.Controller.SensorController;
import fr.campuse.squaregame.demo.RandomHeartbeat;
import fr.campuse.squaregame.demo.Sensor;
import fr.campuse.squaregame.demo.repository.SensorRepo;
import fr.campuse.squaregame.demo.Exception.ProductNotFoundException;
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

        return controller.stream()
                .filter(sensor -> sensor.getID() != 0)
                .findFirst()
                .orElseThrow(() -> new ProductNotFoundException(ID));
        //return controller.get(ID);
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
