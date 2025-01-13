package fr.epita.cards;


import fr.epita.cards.services.CardDAO;
import fr.epita.cards.services.IPlayerDAO;
import fr.epita.cards.services.PlayerJDBCDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;

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
    public IPlayerDAO getPlayerDAO(DataSource ds){
        return new PlayerJDBCDAO(ds);
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {


        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(getDataSource());


        em.setPackagesToScan("fr.epita.cards.datamodel");
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);
        em.setJpaVendorAdapter(vendorAdapter);

        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "update");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        properties.setProperty("hibernate.show_sql", "true");
        properties.setProperty("hibernate.format_sql", "true");
        em.setJpaProperties(properties);

        return em;
    }


    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }



}
