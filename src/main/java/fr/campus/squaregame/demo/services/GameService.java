package fr.campus.squaregame.demo.services;

import org.springframework.stereotype.Service;

@Service
public interface GameService {
    void addNewGame(int playerNumber, int boardSize);
}
