package fr.epita.cards.services.data.impl.jpa;

import fr.epita.cards.datamodel.Card;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.sql.Connection;
import java.sql.SQLException;

public class CardJPADAO {


    @PersistenceContext
    private EntityManager em;

    public CardJPADAO(){
    }

    public void create(Card card) throws SQLException {
        em.persist(card);
    }

    public void update(Card newVersion) throws SQLException {
        em.merge(newVersion);
    }

    public void delete(Card card) throws SQLException {
        em.remove(card);
    }


}
