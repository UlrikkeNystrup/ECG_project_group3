package data;

import java.sql.*;


public class MysqlCon {
    public static void main(String[] args) {

        try {
            // get a connection to database:
            //Class.forName("com.mysql.jdbc.Driver");  //tror ikke denne linje er nødvendig
            Connection connection = DriverManager.getConnection("jdbc:mysql://db.caprover.diplomportal.dk/s215849?"
                    + "user=s215849&password=9dp9i23fJclFnSu68dWl1");
            // Julianes database: "jdbc:mysql://db.diplomportal.dk/s215843?", "s215843", "jR7TTGSR3dcoVhKeiAUHU"


            // create a statement:
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM doctor WHERE auth_id = 20");
            //connection.prepareStatement("SELECT * FROM doctor WHERE auth_id = 222");
            //statement.setString(222,auth_id);

            //Execute SQL query:
                //executeQuery() giver et Resultset. executeUpdate() giver antallet af rækker der blev ændret, INSERT, UPDATE, DELETE
            ResultSet resultset = statement.executeQuery("SHOW TABLES");

            // Process the result set:

            while (resultset.next())
                System.out.println(resultset.getString(1));
                System.out.println(resultset.getString(2));
                System.out.println(resultset.getString(3));
                //System.out.println(resultset.getString("firstname") + " " + resultset.getString("lastname"));

        } catch (Exception e) {
            e.printStackTrace();
        }}}

            /*
            String sql = "insert into doctor"
                    + "(auth_id, firstname, lastname)"
                    + " values ('111', 'david', 'olesen')";
            statement.executeUpdate(sql);

            System.out.println("Insert complete");


            connection.close();
        }catch(Exception e){System.out.println(e);}
*/


