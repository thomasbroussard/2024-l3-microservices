package fr.epita.cards.services.data.impl.jpa;

import fr.epita.cards.datamodel.Card;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.sql.Connection;
import java.sql.SQLException;

public class CardJPADAO {


    @PersistenceContext
    private EntityManager em;

    public CardJPADAO(){
    }

    @Transactional
    public void create(Card card)  {
        em.persist(card);
    }

    @Transactional
    public void update(Card newVersion) {
        em.merge(newVersion);
    }

    @Transactional
    public void delete(Card card)  {
        em.remove(card);
    }


    public Card get(int id) {
        return em.find(Card.class, id);
    }
}
