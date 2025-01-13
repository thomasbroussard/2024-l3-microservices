package fr.epita.cards.services;

import fr.epita.cards.datamodel.Player;
import fr.epita.cards.services.exceptions.PlayerCreationException;

import java.util.List;

public interface IPlayerDAO {
    void create(Player player) throws PlayerCreationException;

    void update(Player player);

    void delete(Player player);

    Player get(String email);

    List<Player> searchPlayers();
}
