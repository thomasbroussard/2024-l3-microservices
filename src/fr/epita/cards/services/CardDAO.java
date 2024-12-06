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

    public void delete(Card card) throws SQLException {

        Connection connection = getConnection();

        String deleteSQL = "DELETE FROM CARDS where value=? and color=? ";
        PreparedStatement deleteStatement = getDeleteStatement(connection, deleteSQL);
        deleteStatement.setInt(1, card.getValue());
        deleteStatement.setString(2, card.getColor());
        deleteStatement.execute();

        connection.close();
    }

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:h2:mem:test_mem",
                "test",
                "pwd");
    }

    private static PreparedStatement getDeleteStatement(Connection connection, String deleteSQL) throws SQLException {
        return connection.prepareStatement(deleteSQL);
    }

}
