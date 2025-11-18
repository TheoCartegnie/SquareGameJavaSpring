package fr.campus.squaregame.demo.model.gameCatalog;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GameCatalog {


    public void addNewGame(int numberPlayer, int boardSize);
    public List<String> getGameIdentifiers();

}
