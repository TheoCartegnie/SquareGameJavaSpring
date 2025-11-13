package fr.campuse.squaregame.demo;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RandomHeartbeat implements HeartbeatSensor {

    Random ran;
    public int ID;

    @Override
    public int getBeat() {
        return 0;
    }

    public int getRandomBeat()
    {
        ran = new Random();
        return ran.nextInt(100,150);
    }
}
