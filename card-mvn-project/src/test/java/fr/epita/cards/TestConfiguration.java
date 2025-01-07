package fr.epita.cards;

import fr.epita.cards.services.Configuration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestConfiguration {

    private static final Logger LOGGER = LogManager.getLogger(TestConfiguration.class);

    @Test
    public void testConfigurationCreation(){
        //when
        Configuration instance = Configuration.getInstance();

        //then
        Assertions.assertThat(instance).isNotNull();
    }

    @Test
    public void testConfigurationKeyRetrieval(){
        //when
        Configuration instance = Configuration.getInstance();

        //then
        Assertions.assertThat(instance).isNotNull();
        String dbUser = instance.get("db.user");
        Assertions.assertThat(dbUser).isEqualTo("test");

        LOGGER.info(dbUser);

    }


}
