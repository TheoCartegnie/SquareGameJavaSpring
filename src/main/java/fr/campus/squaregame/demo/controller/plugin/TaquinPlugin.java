package fr.campus.squaregame.demo.controller.plugin;

import fr.campus.squaregame.demo.GameCreationRespons;
import fr.campus.squaregame.demo.services.GamePlugin;
import fr.le_campus_numerique.square_games.engine.taquin.TaquinGameFactory;
import fr.le_campus_numerique.square_games.engine.tictactoe.TicTacToeGameFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class TaquinPlugin implements GamePlugin {

    TaquinGameFactory factory;

    @Autowired
    void TaquinPlugin()
    {
        factory =  new TaquinGameFactory();
    }

    @Override
    public String getName(Locale l) {
        return "Taquin";
    }

    @Override
    public GameCreationRespons createGame(int playerCount, int boardSize) {
        var game = factory.createGame(playerCount,boardSize);

        GameCreationRespons request = new GameCreationRespons();
        request.boardSize =  game.getBoardSize();
        request.playerNumber = game.getPlayerIds().size();

        return request;
    }
}
