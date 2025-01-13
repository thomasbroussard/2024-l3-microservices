package fr.epita.cards.services.data.impl.jpa;

import fr.epita.cards.datamodel.Round;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class RoundJPADAO {

    @PersistenceContext
    EntityManager em;


    public RoundJPADAO(){

    }

    //create
    public void create(Round round){
        em.persist(round);
    }


    //update

}
