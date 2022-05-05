package data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//OBS. bare en klasse til test af databasen, anvendes ikke i applikationen

public class MySqlConnectionTester {

    public static void main(String[] args) {
        //etabler forbindelsen til databasen ved at oprette et Connection objekt og bruge ConnectionController klassens metode getConnection
        Connection connection = MySqlConnection.getConnection();

        try {
            //opret et statement
            Statement statement = connection.createStatement();

            //Execute SQL query
            //indsæt ny række i tabellen doctor

            String sql = "INSERT INTO doctor"
                    + "(auth_id, first_name, sur_name)"
                    + " values ('4', 'Signe', 'Koefoed')";
            statement.executeUpdate(sql);
            System.out.println("Insert complete");

            //vis alle kollonner fra tabellen doctor
            ResultSet show_tables = statement.executeQuery("SELECT * FROM doctor");

            //processer resultset
            // gennemløb resultsettet og print ud til konsollen. dvs. udskriver alle kolloners værdier for alle rækker i tabellen doctor
            while (show_tables.next()) {
                System.out.println(show_tables.getString(1));
                System.out.println(show_tables.getString(2));
                System.out.println(show_tables.getString(3));
            }

            //luk forbindelsen til databasen efter brug
            connection.close();
            System.out.println("Connection closed");

        }catch(SQLException e){
                e.printStackTrace();
        }


    }

}

