package fr.campus.squaregame.demo.model.gameCatalog;

import fr.campus.squaregame.demo.GameCreationRespons;
import fr.campus.squaregame.demo.controller.plugin.FourGamePlugin;
import fr.campus.squaregame.demo.controller.plugin.TaquinPlugin;
import fr.campus.squaregame.demo.controller.plugin.TicTacToePlugin;
import fr.campus.squaregame.demo.services.GamePlugin;
import fr.le_campus_numerique.square_games.engine.connectfour.ConnectFourGameFactory;
import fr.le_campus_numerique.square_games.engine.taquin.TaquinGameFactory;
import fr.le_campus_numerique.square_games.engine.tictactoe.TicTacToeGameFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class GameCatalogImp implements GameCatalog {

    private List<String> identifiers = new ArrayList<>() ;

    private GamePlugin gamePlugin;


    public void init()
    {
        this.identifiers = new ArrayList<>();
    }

    @Override
    public GameCreationRespons addGame(String name,int numberPlayer, int boardSize) {

        gamePlugin = getGame(name);

        GameCreationRespons respons = gamePlugin.createGame(numberPlayer,boardSize);

        Locale l = new Locale("fr","FR");

        identifiers.add(gamePlugin.getName(l));

        return respons;
    }

    public GamePlugin getGame(String name)
    {
        try {
            switch (name) {
                case "TicTacToe" -> {
                    return new TicTacToePlugin();
                }
                case "Taquin" -> {
                    return new TaquinPlugin();
                }
                case "FourGame" -> {
                    return new FourGamePlugin();
                }
            }

        }
        catch (NullPointerException e)
        {
            System.out.println("There is no game named : " + name);
        }
        return null;
    }

    @Override
    public List<String> getGameIdentifiers() {
        return identifiers;
    }


}
