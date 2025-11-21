package fr.campus.squaregame.demo.services;

import fr.campus.squaregame.demo.GameCreationRespons;
import fr.campus.squaregame.demo.model.gameCatalog.GameCatalogImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.OptionalInt;

@Service
public class GameServiceImpl {

    @Autowired
    public GameCatalogImp gameCatalog;

    public String getName(Local l) {
        return gameCatalog.getGameIdentifiers().get(0);
    }


    public GameCreationRespons createGame(String gameName,int playerCount, int boardSize) {
        return gameCatalog.addGame(gameName,playerCount,boardSize);
    }
}
