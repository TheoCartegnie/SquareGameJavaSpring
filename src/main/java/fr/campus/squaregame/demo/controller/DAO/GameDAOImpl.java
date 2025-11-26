package fr.campus.squaregame.demo.controller.DAO;

import fr.le_campus_numerique.square_games.engine.Game;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GameDAOImpl implements GameDAO{


    List<Game> games = new ArrayList<>();

    @Override
    public void save(Game game) {
        games.add(game);
    }

    @Override
    public List<Game> getAll() {
        return games;
    }

    @Override
    public Game get(int id) {
        return games.get(id);
    }

    @Override
    public void update(Game game) {
    for(int i =0; i < games.size();i++)
    {
        if(games.get(i).getId() == game.getId())
        {
            games.set(i,game);
        }
    }

    }

    @Override
    public void delete(Game game) {
            games.remove(game);
    }
}
