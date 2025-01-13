package fr.epita.cards;


import fr.epita.cards.datamodel.Player;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ApplicationConfiguration.class)
@Transactional
public class TestHibernate {

    @PersistenceContext
    EntityManager em;

    @Test
    public void test(){

        //given
        Player player = new Player();
        player.setName("test");
        player.setEmailAddress("test@test.com");

        //when
        em.persist(player);

        //then?

    }


}
