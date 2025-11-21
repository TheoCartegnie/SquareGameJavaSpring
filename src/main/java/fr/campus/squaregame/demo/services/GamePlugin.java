package fr.campus.squaregame.demo.services;

import fr.campus.squaregame.demo.GameCreationRespons;
import fr.le_campus_numerique.square_games.engine.GameFactory;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.Locale;
import java.util.OptionalInt;

public interface GamePlugin {

    public GameFactory factory = null;

    @NotBlank
    public String getName(Locale l);

    @NotNull
    GameCreationRespons createGame(int playerCount, int boardSize);
}
