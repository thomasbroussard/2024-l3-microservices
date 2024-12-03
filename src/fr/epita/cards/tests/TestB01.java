package fr.epita.cards.tests;

import fr.epita.cards.datamodel.Card;

import java.sql.*;

public class TestB01 {

    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:h2:mem:test_mem",
                "test",
                "pwd");

        String createSQL = "CREATE TABLE CARDS(val int, color varchar)";
        PreparedStatement createStatement = connection.prepareStatement(createSQL);
        createStatement.execute();

        String insertSQL = "INSERT INTO CARDS(val, color) values (7, 'HEART') ";
        PreparedStatement insertStatement = connection.prepareStatement(insertSQL);
        insertStatement.execute();


        String selectSQL = "SELECT val, color FROM CARDS WHERE val = ?";
        PreparedStatement selectStatement = connection.prepareStatement(selectSQL);
        selectStatement.setInt(1, 7);
        ResultSet resultSet = selectStatement.executeQuery();
        while (resultSet.next()){
            String color = resultSet.getString("color");
            int value = resultSet.getInt("val");
            Card card = new Card(value, color);
            System.out.println(card);
        }

        connection.close();


    }
}
