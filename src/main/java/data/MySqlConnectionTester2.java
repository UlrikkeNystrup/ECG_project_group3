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

            //opret preparedStatement og udfør SQL query, indsæt data
            String sql = "INSERT INTO doctor (first_name,sur_name, auth_id) VALUES(?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, first_name);
            preparedStatement.setString(2, sur_name);
            preparedStatement.setString(3, auth_id);
            int rowsInserted = preparedStatement.executeUpdate(); //anvender executeUpdate() metoden, fordi vi manipulerer data (indsætter ny data)
            if (rowsInserted > 0) {
                System.out.println("Successfully Inserted");  //udskriv bedsked til konsollen, hvis der er indsat ny data
            }

            //ny SQL query - slet data
            System.out.println("Type in auth_id for the doctor to be deleted from table:"); //udskriv besked til konsollen
            String auth_id2 = scanner.next(); //opret String objekt og tildel værdien fra det indtastede

            String sql2 = "DELETE FROM doctor WHERE auth_id = ?";
            PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
            preparedStatement2.setString(1, auth_id2);

            int rowsDeleted = preparedStatement2.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("A doctor was deleted successfully!");
            }

            //ny SQL query, vis data i et resultSet
            ResultSet resultSet = preparedStatement.executeQuery("SELECT * FROM doctor"); //anvender executeQuery fordi vi vil have et resultSet udskrevet (vise data fra databasen)

            //gennemløber dvs. itererer over resultSet
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
