package fr.epita.cards;


import fr.epita.cards.datamodel.Card;
import fr.epita.cards.services.data.impl.jdbc.CardDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.sql.*;
import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ApplicationConfiguration.class)
public class TestCardDAO {

    private static final Logger LOGGER = LogManager.getLogger(TestCardDAO.class);
    private Connection connection;

    @Autowired
    DataSource ds;

    @Autowired
    CardDAO dao;

    @BeforeEach
    public void setUp() throws SQLException {
        this.connection = getConnection();
    }

    @Test
    //Given a card, When I create that card using a dao, Then I should be able to retrieve it in the database
    public void testCardDAO_add() throws SQLException {
        //given
        Card card = new Card(4, "SPADES");
        String dropSQL = "DROP TABLE IF EXISTS CARDS";
        String createSQL = "CREATE TABLE CARDS(val int, color varchar)";

        connection.prepareStatement(dropSQL).execute();
        PreparedStatement createStatement = connection.prepareStatement(createSQL);
        createStatement.execute();

        //when
        dao.add(card);

        //then
        ResultSet resultSet = connection.prepareStatement("SELECT * FROM CARDS").executeQuery();
        while (resultSet.next()) {
            String color = resultSet.getString("color");
            Integer value = resultSet.getInt("val");
            assertThat(color).isEqualTo(card.getColor());
            assertThat(value).isEqualTo(card.getValue());
        }


    }

    private static Connection getConnection() throws SQLException {
        LOGGER.debug("getting the connection");
        return DriverManager.getConnection("jdbc:h2:mem:test_mem",
                "test",
                "pwd");
    }


    @Test
    public void test() {
        System.out.println("test method from junit");
      //  Assertions.fail("not implemented yet");
    }


    @AfterEach
    public void cleanUp() throws SQLException {
        this.connection.close();
        LOGGER.debug("connection released");
    }

}
