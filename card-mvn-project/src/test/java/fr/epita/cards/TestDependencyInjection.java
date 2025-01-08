package fr.epita.cards;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ApplicationConfiguration.class)
public class TestDependencyInjection {

    private static final Logger LOGGER = LogManager.getLogger(TestDependencyInjection.class);

    @Autowired
    DataSource dataSource;


    @Test
    public void test() throws SQLException {
        //when
        Connection connection = dataSource.getConnection();

        //then
        Assertions.assertThat(connection).isNotNull();
        Assertions.assertThat(connection.getSchema()).isEqualTo("PUBLIC");

        LOGGER.info(connection.getSchema());
    }

    //TODO do a new test method that logs in debug your user bean (previously injected)



}
