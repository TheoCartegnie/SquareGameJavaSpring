package fr.campus.squaregame.demo.services;


import fr.campus.squaregame.demo.dto.GameListRespons;

import java.util.List;

public interface GameService {

    List<GameListRespons> getGamesID();
    String getGameByID(int ID);
}
