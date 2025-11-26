package fr.campus.squaregame.demo.services;

import fr.campus.squaregame.demo.dto.GameCreationRespons;
import fr.le_campus_numerique.square_games.engine.Game;
import fr.le_campus_numerique.square_games.engine.GameFactory;
import fr.le_campus_numerique.square_games.engine.taquin.TaquinGame;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Value;


import java.util.Locale;

public interface GamePlugin {

   
    public Game getGame();

    @NotBlank
    public String getName(Locale l);

    @NotNull
    GameCreationRespons addGame(@Value("${game.defaultplayerCount}") int playerCount, @Value("${game.DefaultBoardSize}" )int boardSize);
}
