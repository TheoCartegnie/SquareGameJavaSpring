package fr.campus.squaregame.demo.controller.plugin;

import fr.campus.squaregame.demo.dto.GameCreationRespons;
import fr.campus.squaregame.demo.services.GamePlugin;
import fr.le_campus_numerique.square_games.engine.tictactoe.TicTacToeGameFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class TicTacToePlugin extends GamePluginImpl {



    @Value("${game.ticTacToePlugin.defaultplayerCount}")
    protected int defautPlayerCount;


    @Value("${game.ticTacToePlugin.defaultBoardSize}")
    protected int defautBoardSize;

    @Autowired
    public TicTacToePlugin()
    {
        factory = new TicTacToeGameFactory();
    }

    @Override
    public String getName(Locale l) {
        return "TicTacToe";
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

        return CreateGame(playerCount,boardSize);
        //return request;
    }

    @Override
    public GameCreationRespons CreateGame(int playerCount, int boardSize)
    {
        return super.CreateGame(playerCount,boardSize);
    }


}
