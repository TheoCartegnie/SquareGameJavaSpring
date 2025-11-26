package fr.campus.squaregame.demo.model.gameCatalog;

import fr.campus.squaregame.demo.controller.DAO.GameDAOImpl;
import fr.campus.squaregame.demo.dto.GameCreationRespons;
import fr.campus.squaregame.demo.controller.plugin.FourGamePlugin;
import fr.campus.squaregame.demo.controller.plugin.TaquinPlugin;
import fr.campus.squaregame.demo.controller.plugin.TicTacToePlugin;
import fr.campus.squaregame.demo.services.GamePlugin;
import fr.le_campus_numerique.square_games.engine.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.expression.spel.ast.Identifier;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GameCatalogImp implements GameCatalog {


    @Value("${game.GameCatalog.defaultName}")
    private String defaultName;


    @Autowired
    GameDAOImpl DAO;

    @Autowired
    Map<String, GamePlugin> games;
    @Autowired
    TicTacToePlugin tictactoe;
    @Autowired
    FourGamePlugin fourgames;
    @Autowired
    TaquinPlugin taquin;

    @Autowired
    public GameCatalogImp()
    {
        this.identifiers = new ArrayList<>();
    }

    private List<String> identifiers = new ArrayList<>() ;

    private GamePlugin gamePlugin;

    public GameCreationRespons addGame() {
        return addGame(defaultName, 0, 0);
    }


    public Map<String,GamePlugin> getGames()
    {
        return games;
    }

    @Override
    public GameCreationRespons addGame(String name, int numberPlayer, int boardSize) {

        Locale l = new Locale("fr","FR");
        if(name == null)
        {
            name = defaultName;
        }
        String id = UUID.randomUUID().toString();

        gamePlugin = getGame(name);
        games.put(id,gamePlugin);
        identifiers.add(id);
        DAO.save(gamePlugin.getGame());
        GameCreationRespons respons = GenerateRespons(numberPlayer, boardSize, l, id);


        return respons;
    }

    private GameCreationRespons GenerateRespons(int numberPlayer, int boardSize, Locale l, String id) {
        GameCreationRespons respons = gamePlugin.addGame(numberPlayer, boardSize);

        respons.name = gamePlugin.getName(l);
        respons.ID = id;
        identifiers.add(id);
        return respons;
    }

    public void deleteGame(int ID)
    {
       String str = identifiers.get(ID);
       if(games.containsKey(str)) {
           games.remove(str);
       }
    }

    public GamePlugin getGame(String name)
    {
        try {
            switch (name) {
                case "TicTacToe" -> {
                    return tictactoe;
                }
                case "Taquin" -> {
                    return taquin;
                }
                case "FourGame" -> {
                    return fourgames;
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
