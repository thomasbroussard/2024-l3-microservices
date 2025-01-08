package fr.epita.cards.services;

import fr.epita.cards.datamodel.Player;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import javax.xml.crypto.Data;

public class PlayerDAO {


    private final DataSource datasource;

    public PlayerDAO(@Autowired DataSource ds){
        this.datasource = ds;
    }

    public void create(Player player){


    }

    public void update(Player player){

    }

    public void delete(Player player){

    }

    public void get(String email){

    }


}
