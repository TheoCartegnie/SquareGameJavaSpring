package fr.campus.squaregame.demo.controller.plugin;

import fr.campus.squaregame.demo.GameCreationRespons;
import fr.campus.squaregame.demo.services.GamePlugin;
import fr.le_campus_numerique.square_games.engine.connectfour.ConnectFourGameFactory;
import fr.le_campus_numerique.square_games.engine.tictactoe.TicTacToeGameFactory;
import fr.le_campus_numerique.square_games.engine.connectfour.ConnectFourGameFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class FourGamePlugin implements GamePlugin {


    ConnectFourGameFactory factory;

    @Autowired
    public FourGamePlugin()
    {
        factory = new ConnectFourGameFactory();
    }

    @Override
    public String getName(Locale l) {
        return "FourGame";
    }

    @Override
    public GameCreationRespons createGame(int playerCount, int boardSize) {
        var game = factory.createGame(playerCount,boardSize);

        GameCreationRespons request = new GameCreationRespons();
        request.boardSize = game.getBoardSize();
        request.playerNumber = game.getPlayerIds().size();

        return request;
    }
}
