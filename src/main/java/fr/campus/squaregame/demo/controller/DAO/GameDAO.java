package fr.campus.squaregame.demo.controller.DAO;

import fr.le_campus_numerique.square_games.engine.Game;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GameDAO {
    public void save(Game game);
    public List<Game> getAll();
    public Game get(int id);
    public void update(Game game);
    public void delete(Game game);

}
