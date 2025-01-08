package fr.epita.cards.services;

import fr.epita.cards.datamodel.Player;
import fr.epita.cards.services.exceptions.PlayerCreationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PlayerDAO {


    private static final Logger LOGGER = LogManager.getLogger(PlayerDAO.class);
    private final DataSource datasource;

    public PlayerDAO(@Autowired DataSource ds){
        this.datasource = ds;
    }

    public void create(Player player) throws PlayerCreationException {
        try(Connection connection = this.datasource.getConnection();){
            PreparedStatement insertstmt
                    = connection.prepareStatement("INSERT INTO PLAYERS(name, email) VALUES (?,?)");
            insertstmt.setString(1, player.getName());
            insertstmt.setString(2, player.getEmailAddress());
            insertstmt.execute();
        }catch (SQLException e){
            LOGGER.error(e);
            PlayerCreationException createException = new PlayerCreationException();
            createException.initCause(e);
            throw createException;
        }

    }

    public void update(Player player){

    }

    public void delete(Player player){

    }

    public Player get(String email){
        try (Connection connection = datasource.getConnection()) {
            PreparedStatement getStatement = connection.prepareStatement("SELECT name, email from PLAYERS where email = ?");
            getStatement.setString(1, email);
            ResultSet resultSet = getStatement.executeQuery();
            if (resultSet.isLast()){
                //TODO check if it is empty in a better way
                return null;
            }
            resultSet.next();
            String foundEmail = resultSet.getString("email");
            String foundName = resultSet.getString("name");
            Player player = new Player();
            player.setEmailAddress(foundEmail);
            player.setName(foundName);
            return player;
        }catch (SQLException sqlException){
            LOGGER.error(sqlException);
        }
        return null;
    }


}
