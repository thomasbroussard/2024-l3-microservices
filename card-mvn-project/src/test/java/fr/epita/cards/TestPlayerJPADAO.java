package fr.epita.cards;


import fr.epita.cards.datamodel.Player;
import fr.epita.cards.services.IPlayerDAO;
import fr.epita.cards.services.PlayerJPADAO;
import fr.epita.cards.services.exceptions.PlayerCreationException;
import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ApplicationConfiguration.class)
@Transactional
public class TestPlayerJPADAO {


    @Autowired
    DataSource dataSource;

    @Autowired
    PlayerJPADAO dao;

    @Test
    @DisplayName(" whenCreatingAPlayerIShouldRetrieveItInDB")
    public void testCreation() throws SQLException, PlayerCreationException {

        //given
        Player player = new Player();
        player.setName("test");
        player.setEmailAddress("test@test.com");

        //when
        dao.create(player);

        //then
        Player foundPlayer = dao.get(player.getEmailAddress());
        Assertions.assertThat(foundPlayer).isNotNull();
    }


}
