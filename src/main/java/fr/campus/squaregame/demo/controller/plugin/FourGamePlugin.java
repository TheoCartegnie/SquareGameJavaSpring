package fr.campus.squaregame.demo.controller.plugin;

import fr.campus.squaregame.demo.dto.GameCreationRespons;
import fr.campus.squaregame.demo.services.GamePlugin;
import fr.le_campus_numerique.square_games.engine.connectfour.ConnectFourGameFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class FourGamePlugin extends GamePluginImpl {

    @Value("${game.fourGamePlugin.defaultplayerCount}")
    int defautPlayerCount;

    @Value("${game.fourGamePlugin.defaultBoardSize}")
    int defautBoardSize;

    @Autowired
    public FourGamePlugin()
    {
        factory = new ConnectFourGameFactory();
    }



    @Override
    public String getName(Locale l) {
        return "FourGame";
    }

    public GameCreationRespons addGame(int playerCount, int boardSize)
    {
        if(playerCount == 0)
        {
            playerCount = this.defautPlayerCount;
        }
        if(boardSize == 0)
        {
            boardSize = this.defautBoardSize;
        }
        return super.CreateGame(playerCount,boardSize);
        //return request;
    }
}
