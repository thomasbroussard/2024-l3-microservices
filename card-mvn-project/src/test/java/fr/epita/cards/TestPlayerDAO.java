package fr.epita.cards;


import fr.epita.cards.datamodel.Player;
import fr.epita.cards.services.PlayerDAO;
import fr.epita.cards.services.exceptions.PlayerCreationException;
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
public class TestPlayerDAO {


    @Autowired
    DataSource dataSource;

    @Autowired
    PlayerDAO dao;

    @Test
    @DisplayName(" whenCreatingAPlayerIShouldRetrieveItInDB")
    public void testCreation() throws SQLException, PlayerCreationException {

        //given
        String dropSQL = "DROP TABLE IF EXISTS PLAYERS";
        String createSQL = "CREATE TABLE PLAYERS(name varchar(255), email varchar(255))";

        Connection connection = dataSource.getConnection();
        connection.prepareStatement(dropSQL).execute();
        connection.prepareStatement(createSQL).execute();
        Player player = new Player();
        player.setName("test");
        player.setEmailAddress("test@test.com");

        //when
        dao.create(player);

        //then
        ResultSet resultSet = connection.prepareStatement("SELECT * from PLAYERS").executeQuery();
        int i = 0;
        while (resultSet.next()){
            i++;
            //more intensive test
        }
        Assertions.assertThat(i).isEqualTo(1);
    }


}
