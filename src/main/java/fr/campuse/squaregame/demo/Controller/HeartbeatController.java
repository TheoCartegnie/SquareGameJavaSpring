package fr.campuse.squaregame.demo.Controller;

import fr.campuse.squaregame.demo.RandomHeartbeat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeartbeatController{

  @Autowired
  private RandomHeartbeat heartBeatSensor;

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



}
