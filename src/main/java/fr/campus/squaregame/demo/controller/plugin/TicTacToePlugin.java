package fr.campus.squaregame.demo.controller.plugin;

import fr.campus.squaregame.demo.GameCreationRespons;
import fr.campus.squaregame.demo.services.GamePlugin;
import fr.le_campus_numerique.square_games.engine.tictactoe.TicTacToeGameFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.OptionalInt;

@Component
public class TicTacToePlugin implements GamePlugin {


    TicTacToeGameFactory factory;

    @Autowired
    public TicTacToePlugin()
    {
       factory = new TicTacToeGameFactory();
    }

    @Override
    public String getName(Locale l) {
        return "TicTacToe";
    }

    @Override
    public GameCreationRespons createGame(int playerCount, int boardSize)
    {
       var game = factory.createGame(playerCount,boardSize);

        GameCreationRespons request = new GameCreationRespons();
        request.boardSize = game.getBoardSize();
        request.playerNumber = game.getPlayerIds().size();

        return request;
    }


}
