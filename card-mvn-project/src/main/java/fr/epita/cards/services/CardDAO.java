package fr.epita.cards.services;

import fr.epita.cards.datamodel.Card;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CardDAO {

    public void add(Card card) throws SQLException {

        try (Connection connection = getConnection();) {
            String insertSQL = "INSERT INTO CARDS(val, color) values (?, ?) ";
            PreparedStatement insertStatement = connection.prepareStatement(insertSQL);
            insertStatement.setInt(1, card.getValue());
            insertStatement.setString(2, card.getColor());
            insertStatement.execute();
        } catch (SQLException e) {
            //TODO handle the exception
        }
    }

    public void update(Card newVersion, Card oldVersion) throws SQLException {

        try (Connection connection = getConnection();) {
            String updateSQL = "UPDATE CARDS SET val = ?, color=?  WHERE val = ?  and color = ?";
            PreparedStatement updateStatement = connection.prepareStatement(updateSQL);
            updateStatement.setInt(1, newVersion.getValue());
            updateStatement.setString(2, newVersion.getColor());
            updateStatement.setInt(3, oldVersion.getValue());
            updateStatement.setString(4, oldVersion.getColor());
            updateStatement.execute();
        } catch (SQLException e) {
            //TODO handle the exception
        }
    }

    public void delete(Card card) throws SQLException {

        Connection connection = getConnection();

        String deleteSQL = "DELETE FROM CARDS where val=? and color=? ";
        PreparedStatement deleteStatement = connection.prepareStatement(deleteSQL);
        deleteStatement.setInt(1, card.getValue());
        deleteStatement.setString(2, card.getColor());
        deleteStatement.execute();

        connection.close();
    }

    private static Connection getConnection() throws SQLException {
        // use the class "Properties" to load a key value pairs file (conf.properties)
        // try to use the singleton pattern for a class named "Conf" as defined here: https://www.oodesign.com/singleton-pattern
        // invoke that singleton to fill the appropriate info below.

        Configuration conf = Configuration.getInstance();
        return DriverManager.getConnection(
                conf.get("db.url"),
                conf.get("db.user"),
                conf.get("db.pwd")
        );
    }


}
