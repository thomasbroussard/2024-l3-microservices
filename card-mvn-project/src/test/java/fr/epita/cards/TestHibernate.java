package fr.epita.cards;


import fr.epita.cards.datamodel.Player;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ApplicationConfiguration.class)
@Transactional
@Commit
public class TestHibernate {

    @PersistenceContext
    EntityManager em;

    @Autowired
    DataSource dataSource;

    @Test
    public void test() throws SQLException {

        //given
        Player player = new Player();
        player.setName("test");
        player.setEmailAddress("test@test.com");

        //when
        em.persist(player);


        //then?
        ResultSet resultSet = dataSource.getConnection().prepareStatement("SELECT * from PLAYERS").executeQuery();
        int i = 0;
        while (resultSet.next()){
            i++;
            //more intensive test
        }
        Assertions.assertThat(i).isEqualTo(1);

    }

    @Test
    public void testUsingEMtoRetrieve() throws SQLException {

        //given
        Player player = new Player();
        player.setName("test");
        player.setEmailAddress("test@test1.com");

        //when
        em.persist(player);

        //then
        Player foundPlayer = em.find(Player.class, "test@test.com");
        Assertions.assertThat(foundPlayer).isNotNull();

    }



}
