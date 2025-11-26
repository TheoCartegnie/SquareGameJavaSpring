package fr.campus.squaregame.demo.controller.plugin;

import fr.campus.squaregame.demo.dto.GameCreationRespons;
import fr.campus.squaregame.demo.services.GamePlugin;
import fr.le_campus_numerique.square_games.engine.Game;
import fr.le_campus_numerique.square_games.engine.GameFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Locale;

public class GamePluginImpl implements GamePlugin {

    public GameFactory factory = null;
    public Game game = null;
    Game currentGame = null;


    public Game getGame()
    {
        return game;
    }

    @Override
    public String getName(Locale l) {
        return "";
    }

    

    @Override
    public GameCreationRespons addGame(int playerCount, int boardSize) {

        GameCreationRespons request = CreateGame(playerCount, boardSize);

        return request;
    }



    protected GameCreationRespons CreateGame(int playerCount, int boardSize) {
        var game = createGame(playerCount, boardSize);
        GameCreationRespons request = new GameCreationRespons();
        request.boardSize = game.getBoardSize();
        request.playerNumber = game.getPlayerIds().size();
        return request;
    }

    private Game createGame(int playerCount, int boardSize) {
        var currentgame = factory.createGame(playerCount, boardSize);
        game = currentgame;
        return currentgame;
    }
}
