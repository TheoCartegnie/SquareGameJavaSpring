package fr.campus.squaregame.demo.services;


import java.util.ArrayList;
import java.util.List;

public interface GameService {
    void addNewGame(int playerNumber, int boardSize);
    void addTaquin(int playerNumber, int boardSize);
    void addTicTacToe(int playerNumber, int boardSize);
    void addFourGame(int playerNumber, int boardSize);
    List<String> getGamesID();
}
