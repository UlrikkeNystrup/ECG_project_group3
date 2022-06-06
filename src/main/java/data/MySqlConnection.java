package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//dennne klasse opretter forbindelsen til databasen
public class MySqlConnection {

    //Create a Connection object
    private static Connection connection;

    //Create a Connection method
    public static Connection getConnection(){ // metode typen er Connection, dermed skal metoden returnere et connection objekt (ligesom hvis det vat en int eller double)
        try {
            if (connection==null || connection.isClosed()) {
                connection = DriverManager.getConnection("jdbc:mysql://db.caprover.diplomportal.dk/s215849?"
                        + "user=s215849&password=9dp9i23fJclFnSu68dWl1");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    private MySqlConnection(){ //hvad bruges denne konstruktør til? slet?
    }
}
