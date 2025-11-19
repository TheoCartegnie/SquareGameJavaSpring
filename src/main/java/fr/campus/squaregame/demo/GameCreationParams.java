package fr.campus.squaregame.demo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.UUID;

public class GameCreationParams {

    public String ID;
    public Integer playerNumber;
    public Integer boardSize;

    public GameCreationParams(){};
    public GameCreationParams(int playerNumber, int boardsize)
    {
        this.playerNumber = playerNumber;
        this.boardSize = boardsize;
    }

}
