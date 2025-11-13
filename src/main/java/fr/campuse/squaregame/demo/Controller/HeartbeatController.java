package fr.campuse.squaregame.demo.Controller;

import fr.campuse.squaregame.demo.HeartbeatSensor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeartbeatController {

  @Autowired
  private HeartbeatSensor heartBeatSensor;


  @GetMapping("/heartbeat")
  public int getHeartbeat()
  {
     return this.heartBeatSensor.getBeat();
  }

  @GetMapping("/heartbeats")
  public int getRandomBeat()
  {
        return this.heartBeatSensor.getRandomBeat();
  }

    @GetMapping("/sensors")
    public int getSensors()
    {
        HeartbeatSensor [] sensors = new HeartbeatSensor[5];

    }

//  @GetMapping("/heartbeat/{id}")
//  public int getSensorsByID()
//  {
//
//  }
}
