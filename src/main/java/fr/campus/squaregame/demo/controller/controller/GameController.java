package fr.campus.squaregame.demo.controller.controller;

import fr.campus.squaregame.demo.GameCreationParams;
import fr.campus.squaregame.demo.model.gameCatalog.GameCatalogImp;
import fr.campus.squaregame.demo.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class GameController {

    @Autowired
    GameService gameService;

    @PostMapping("/games")
    public String createGame(@RequestBody GameCreationParams params) {
        gameService.addNewGame(params.playerNumber,params.boardSize);
        return UUID.randomUUID().toString();
    }

    @GetMapping("/games/{gameId}")
    public Object getGame(@PathVariable String gameId) {

        return null;
    }

}
