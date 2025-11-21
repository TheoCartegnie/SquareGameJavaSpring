package fr.campus.squaregame.demo.services;


import fr.campus.squaregame.demo.GameCreationRespons;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;

public interface GameService {

    List<String> getGamesID();
    String getGameByID(int ID);
}
