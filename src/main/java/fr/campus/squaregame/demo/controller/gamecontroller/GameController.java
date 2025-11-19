package fr.campus.squaregame.demo.controller.gamecontroller;

import fr.campus.squaregame.demo.GameCreationParams;
import fr.campus.squaregame.demo.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class GameController {

    @Autowired
    GameService gameService;

    @PostMapping("/games/tictactoe")
    public String createTicTacToeGame(@RequestBody GameCreationParams params) {
        gameService.addTicTacToe(params.playerNumber,params.boardSize);
        return UUID.randomUUID().toString();
    }

    @PostMapping("/games/taquin")
    public String createTaquinGame(@RequestBody GameCreationParams params) {
        gameService.addTaquin(params.playerNumber,params.boardSize);
        return UUID.randomUUID().toString();
    }

    @PostMapping("/games/fourGame")
    public String createFourGameGame(@RequestBody GameCreationParams params) {
        gameService.addFourGame(params.playerNumber,params.boardSize);
        return UUID.randomUUID().toString();
    }

    @GetMapping("/games/{gameId}")
    public Object getGame(@PathVariable String gameId) {
        return gameService.getGamesID();
    }

}
