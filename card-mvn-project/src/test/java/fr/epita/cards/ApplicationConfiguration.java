package fr.epita.cards;


import fr.epita.cards.services.CardDAO;
import fr.epita.cards.services.PlayerDAO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import javax.xml.crypto.Data;

@Configuration
public class ApplicationConfiguration {


    @Bean
    public DataSource getDataSource(){
        fr.epita.cards.services.Configuration conf = fr.epita.cards.services.Configuration.getInstance();
        DriverManagerDataSource dataSource = new DriverManagerDataSource(
                conf.get("db.url"),
                conf.get("db.user"),
                conf.get("db.pwd")
        );
        return dataSource;
    }

    // returns a bean of type "String" that contains your name
    @Bean("name")
    public String getName(){
        return "Thomas";
    }

    @Bean("address")
    public String getAddress(){
        return "Paris";
    }

    @Bean
    public CardDAO getCardDAO(DataSource ds){
        return new CardDAO(ds);
    }


    @Bean
    public PlayerDAO getPlayerDAO(DataSource ds){
        return new PlayerDAO(ds);
    }

}
