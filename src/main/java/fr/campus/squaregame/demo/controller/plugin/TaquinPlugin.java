package fr.campus.squaregame.demo.controller.plugin;

import fr.campus.squaregame.demo.dto.GameCreationRespons;
import fr.campus.squaregame.demo.services.GamePlugin;
import fr.le_campus_numerique.square_games.engine.taquin.TaquinGameFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class TaquinPlugin  extends GamePluginImpl {

    @Value("${game.taquinPlugin.defaultplayerCount}")
    int defautPlayerCount;

    @Value("${game.taquinPlugin.defaultBoardSize}")
    int defautBoardSize;

    @Autowired
    public TaquinPlugin()
    {
        factory = new TaquinGameFactory();
    }

    @Override
    public String getName(Locale l) {
        return "Taquin";
    }

    @Override
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
