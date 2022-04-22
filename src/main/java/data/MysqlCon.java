package data;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MysqlCon {
    public static void main(String[] args) {
        try {
            Class.forName("mysql-db.caprover.diplomportal.dk");
            Connection con = DriverManager.getConnection("s215843", "s215843", "jR7TTGSR3dcoVhKeiAUHU");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * form emp");
            while (rs.next())
                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
            con.close();
        }catch(Exception e){System.out.println(e);}
}}
