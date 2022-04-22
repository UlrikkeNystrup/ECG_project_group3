package data;

import java.sql.*;


public class MysqlCon {
    public static void main(String[] args) {

        try {
            // get a connection to database:
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://db.diplomportal.dk/s215843?", "s215843", "jR7TTGSR3dcoVhKeiAUHU");

            // create a statement:
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM doctor WHERE auth_id = 222");
            //statement.setString(222,auth_id);

            //Exsecute SQL query:
            ResultSet resultset = statement.executeQuery();

            // Process the result set:

            while (resultset.next())
                System.out.println(resultset.getString("firstname") + " " + resultset.getString("lastname"));

        } catch (Exception e) {
            e.printStackTrace();
        }}}

            /*
            String sql = "insert into doctor"
                    + "(auth_id, firstname, lastname)"
                    + " values ('111', 'david', 'olesen')";
            statement.executeUpdate(sql);

            System.out.println("Insert complete");


            con.close();
        }catch(Exception e){System.out.println(e);}
*/


