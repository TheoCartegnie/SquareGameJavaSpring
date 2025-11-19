package fr.campus.squaregame.demo.services;

import fr.campus.squaregame.demo.model.gameCatalog.GameCatalogImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    public GameCatalogImp gameCatalog;


   @Override
   public void addNewGame(int playerNumber, int boardSize)
   {
       gameCatalog.addNewGame(playerNumber,boardSize);
   }

    @Override
    public void addTaquin(int playerNumber, int boardSize) {
        gameCatalog.addTaquin(playerNumber,boardSize);
    }

    @Override
    public void addTicTacToe(int playerNumber, int boardSize) {
        gameCatalog.addTicTacToe(playerNumber,boardSize);
    }

    @Override
    public void addFourGame(int playerNumber, int boardSize) {
        gameCatalog.addfourGame(playerNumber,boardSize);
    }

    @Override
    public List<String> getGamesID() {
      return gameCatalog.getGameIdentifiers();
    }

    @Override
    public String getGameByID(int ID) {
        return gameCatalog.getGameIdentifiers().get(ID);
    }


}
