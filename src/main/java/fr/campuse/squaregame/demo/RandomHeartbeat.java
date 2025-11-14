package fr.campuse.squaregame.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Random;


@Service
public class RandomHeartbeat implements Sensor {

    @Value("${randomheartbeat.id}")
    private int iD;


    private final Random ran;

    @Autowired
    public RandomHeartbeat(Random ran)
    {
        this.ran =ran;
    }

    @Override
    public int getBeat() {
        return 0;
    }

    @Override
    public int getRandomBeat()
    {
        return ran.nextInt(100,150);
    }

    @Override
    public void setID(int ID) {
        iD = ID;
    }
    @Override
    public int getID()
    {
        return iD;
    }
}
