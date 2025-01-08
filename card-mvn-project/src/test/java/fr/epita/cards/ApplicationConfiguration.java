package fr.epita.cards;


import fr.epita.cards.services.CardDAO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

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
    @Bean
    public String getName(){
        return "Thomas";
    }

    @Bean
    public CardDAO getCardDAO(DataSource ds){
        return new CardDAO(ds);
    }



}
