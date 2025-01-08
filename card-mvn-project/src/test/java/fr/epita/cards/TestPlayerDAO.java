package fr.epita.cards;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ApplicationConfiguration.class)
public class TestPlayerDAO {


    @Test
    @DisplayName(" whenCreatingAPlayerIShouldRetrieveItInDB")
    public void testCreation(){
        String dropSQL = "DROP TABLE IF EXISTS PLAYERS";
        String createSQL = "CREATE TABLE PLAYERS(...)";

    }


}
