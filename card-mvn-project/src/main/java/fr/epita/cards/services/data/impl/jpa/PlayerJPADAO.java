package fr.epita.cards.services.data.impl.jpa;

import fr.epita.cards.datamodel.Player;
import fr.epita.cards.services.data.IPlayerDAO;
import fr.epita.cards.services.exceptions.PlayerCreationException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class PlayerJPADAO implements IPlayerDAO {


    private static final Logger LOGGER = LogManager.getLogger(PlayerJPADAO.class);

    @PersistenceContext
    private EntityManager em;

    public PlayerJPADAO() {
    }

    public void create(Player player) throws PlayerCreationException {
        em.persist(player);
    }
    public void update(Player player) {
        em.merge(player);
    }
    public void delete(Player player) {
        em.remove(player);
    }
    public Player get(String email) {
        return em.find(Player.class, email);
    }

    public List<Player> searchPlayers (){
        return null;
    }
}
