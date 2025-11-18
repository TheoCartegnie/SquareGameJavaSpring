package fr.campus.squaregame.demo.controller.controller;


import fr.campus.squaregame.demo.model.gameCatalog.GameCatalog;
import fr.campus.squaregame.demo.model.gameCatalog.GameCatalogImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GameCatalogController {

    @Autowired
    private GameCatalogImp gameCatalog;

    @GetMapping("/games/list")
    public List<String> getIDs()
    {
        return gameCatalog.getGameIdentifiers();
    }



}
