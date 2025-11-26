package fr.campus.squaregame.demo.controller.gamecontroller;

import fr.campus.squaregame.demo.dto.*;
import fr.campus.squaregame.demo.services.GameServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class GameController {

    @Autowired
    GameServiceImpl gameService;

    @PostMapping("/games")
    public String createGame(@RequestBody GameCreationRespons params) {
        gameService.createGame(params.name,params.boardSize, params.playerNumber );
        return UUID.randomUUID().toString();
    }

    @PostMapping("/games/create")
    public ResponseEntity<GameCreationRespons> creatGame(@RequestBody GameCreationRequest request)
    {
       GameCreationRespons respons = gameService.createGame(request.name,request.playerNumber,request.boardSize);
       return ResponseEntity.ok(respons);
    }

    @GetMapping("/games/list")
    public ResponseEntity<List<GameListRespons>> getGames(@RequestBody GameListRequest request)
    {
       List<GameListRespons> respons = gameService.getGamesID();
       return ResponseEntity.ok(respons);
    }

    @DeleteMapping("/games/delete")
    public ResponseEntity<GameDeleteReponse> deleteGame(@RequestBody GameDeleteRequest request)
    {
        GameDeleteReponse respons = gameService.deleteGame(request.ID);
        return ResponseEntity.ok(respons);
    }
}
