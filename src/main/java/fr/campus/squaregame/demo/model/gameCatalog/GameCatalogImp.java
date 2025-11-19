package fr.campus.squaregame.demo.model.gameCatalog;

import fr.le_campus_numerique.square_games.engine.connectfour.ConnectFourGame;
import fr.le_campus_numerique.square_games.engine.connectfour.ConnectFourGameFactory;
import fr.le_campus_numerique.square_games.engine.taquin.TaquinGameFactory;
import fr.le_campus_numerique.square_games.engine.tictactoe.TicTacToeGameFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameCatalogImp implements GameCatalog {
    TicTacToeGameFactory ticTactToeFactory = new TicTacToeGameFactory();
    TaquinGameFactory taquinFActory = new TaquinGameFactory();
    ConnectFourGameFactory fourGameFactory = new ConnectFourGameFactory();
    private List<String> identifiers = new ArrayList<>() ;


    public void init()
    {
        this.identifiers = new ArrayList<>();
        identifiers.add(ticTactToeFactory.getGameFactoryId());
    }


    public void addTicTacToe(int numberPlayer, int boardSize)
    {
        ticTactToeFactory.createGame(numberPlayer,boardSize);
        identifiers.add(ticTactToeFactory.getGameFactoryId());
    }

    public void addTaquin(int numberPlayer, int boardSize)
    {
        taquinFActory.createGame(numberPlayer,boardSize);
        identifiers.add(taquinFActory.getGameFactoryId());
    }

    public void addfourGame(int numberPlayer, int boardSize)
    {
        fourGameFactory.createGame(numberPlayer,boardSize);
        identifiers.add(fourGameFactory.getGameFactoryId());
    }


    @Override
    public void addNewGame(int numberPlayer, int boardSize)
    {



       // fourGameFactory.createGame(numberPlayer,boardSize);
    }

    @Override
    public List<String> getGameIdentifiers() {
        return identifiers;
    }


}
