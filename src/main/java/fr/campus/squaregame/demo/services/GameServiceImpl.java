package fr.campus.squaregame.demo.services;

import fr.campus.squaregame.demo.dto.*;
import fr.campus.squaregame.demo.model.gameCatalog.GameCatalog;
import fr.campus.squaregame.demo.model.gameCatalog.GameCatalogImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class GameServiceImpl implements GameService {

    @Value("${game.defaultName}")
    String defaultName;

    @Autowired
    public GameCatalogImp gameCatalog;

    public String getName(Local l) {
        return gameCatalog.getGameIdentifiers().get(0);
    }


    public List<String> getGameIDs()
    {
        return gameCatalog.getGameIdentifiers();
    }

    public List<GameListRespons> getGamesID()
    {

        List<GamePlugin> games = gameCatalog.getGames().values().stream().toList();

        List<GameListRespons> responses = new ArrayList<>();
        for(int i = 0; i < games.size();i++)
            {
                GameListRespons message = new GameListRespons();
                message.name = games.get(i).getName(new Locale("fr","FR"));
                responses.add(message);
            }

        return responses;
    }

    public GameDeleteReponse deleteGame(int id)
    {
        List<GamePlugin> games = gameCatalog.getGames().values().stream().toList();
        gameCatalog.deleteGame(id);
        GameDeleteReponse respons = new GameDeleteReponse();

        respons.name = new ArrayList<>();

        respons.name.add("Ha");

        return respons;
    }

    public GameCreationRespons createGame(String gameName,int playerCount, int boardSize) {

        if(gameName == null) {
            gameName = defaultName;
        }

        return gameCatalog.addGame(gameName,playerCount,boardSize);
    }
    

    @Override
    public String getGameByID(int ID) {
        return "";
    }
}
