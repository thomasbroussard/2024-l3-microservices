package fr.epita.cards;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;
import org.h2.jdbcx.JdbcDataSource;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ApplicationConfiguration.class)
public class TestDependencyInjection {

    private static final Logger LOGGER = LogManager.getLogger(TestDependencyInjection.class);

    @Autowired
    DataSource dataSource;

    @Autowired
    @Qualifier("name")
    String theName;



    @Test
    public void test() throws SQLException {
        //when
        Connection connection = dataSource.getConnection();

        //just to demonstrate the concrete type check mechanism thanks to instanceof
        if (dataSource instanceof JdbcDataSource){

        }
        //then
        assertThat(connection).isNotNull();
        assertThat(connection.getSchema()).isEqualTo("PUBLIC");

        LOGGER.info(connection.getSchema());
    }

    @Test
    public void testName(){
        //method that logs in debug your user bean (previously injected)
        assertThat(theName).isEqualTo("Thomas");
        LOGGER.debug(theName);
    }




}
