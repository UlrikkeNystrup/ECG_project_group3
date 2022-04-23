package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class MySqlConnectionTester2 {
    public static void main(String[] args) {
        //etabler forbindelsen til databasen ved at oprette et Connection objekt og bruge ConnectionController klassens metode getConnection
        Connection connection = MySqlConnection.getConnection();

        // SQL queries
        try {
            Scanner scanner = new Scanner(System.in); //opret Scanner objekt
            System.out.println("Type in first_name:"); //udskriv besked til konsollen
            String first_name = scanner.next(); //opret String objekt og tildel værdien fra det indtastede
            System.out.println("Type in sur_name:");
            String sur_name = scanner.next();
            System.out.println("Type in auth_id");
            String auth_id = scanner.next();

            //opret preparedStatement og udfør SQL query
            String sql = "INSERT INTO doctor (first_name,sur_name, auth_id) VALUES(?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, first_name);
            preparedStatement.setString(2, sur_name);
            preparedStatement.setString(3, auth_id);
            preparedStatement.executeUpdate(); //anvender executeUpdate() metoden, fordi vi manipulerer data (indsætter ny data)
            System.out.println("Successfully Inserted");  //udskriv bedsked til konsollen

            //ny SQL query
            ResultSet resultSet = preparedStatement.executeQuery("SELECT * FROM doctor"); //anvender executeQuery fordi vi vil have et resultSet udskrevet (vise data fra databasen)

            //gennemløber resultSet
            while(resultSet.next()){
                System.out.println(resultSet.getString(1)+"  " + resultSet.getString(2)+" "+ resultSet.getInt(3));
            }

            //lukker forbindelsen til databasen
            connection.close();
            System.out.println("Connection closed");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
