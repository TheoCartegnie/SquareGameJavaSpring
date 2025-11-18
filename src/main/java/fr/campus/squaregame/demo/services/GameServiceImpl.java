package fr.campus.squaregame.demo.services;

import fr.campus.squaregame.demo.model.gameCatalog.GameCatalogImp;
import fr.le_campus_numerique.square_games.engine.taquin.TaquinGame;
import fr.le_campus_numerique.square_games.engine.tictactoe.TicTacToeGame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl {

    @Autowired
    public GameCatalogImp gameCatalog;
    @Autowired
    private TicTacToeGame ticTacToeGameFirst;
    @Autowired
    private TaquinGame taquinGame;


   public void addNewGame(int playerNumber, int boardSize)
   {
       gameCatalog.addNewGame(playerNumber,boardSize);
   }


}
