package fr.campus.squaregame.demo.model.gameCatalog;

import fr.campus.squaregame.demo.dto.GameCreationRespons;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GameCatalog {

    public GameCreationRespons addGame(String name, int numberPlayer, int boardSize);

    public List<String> getGameIdentifiers();

}
