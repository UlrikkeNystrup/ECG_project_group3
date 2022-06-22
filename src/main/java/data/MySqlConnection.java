//@author group 2: Ulrikke, Eva, Juliane, Simone og Mikael
package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//dennne klasse opretter forbindelsen til databasen
public class MySqlConnection {

    //Create a Connection object
    private static Connection connection;

    //Create a Connection method
    public static Connection getConnection(){
        /* metode typen er Connection, dermed skal metoden returnere et connection objekt (ligesom hvis det var en int eller double)
        klassemetode, derfor man bruger nøgleordet Static
         */
        try {
            if (connection==null || connection.isClosed()) {
                connection = DriverManager.getConnection("jdbc:mysql://db.caprover.diplomportal.dk/s215849?"
                        + "user=s215849&password=VZQM7OAP0CnLXTZ4rqYgw");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    private MySqlConnection(){ //hvad bruges denne konstruktør til? slet?
    }
}
