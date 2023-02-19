package data.database;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.SQLSyntaxErrorException;

/**
 *
 * @author root
 */
public abstract class DbConnection {

    

    static int count = 0;

    public static Connection getConnection() {

        Connection con = null;
        try {
            if (Database.conn == null) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Database.conn = DriverManager.getConnection(Database.URL + Database.DB_NAME, Database.USERNAME, Database.PASS);
                System.out.println("Connected");

            }
            con = Database.conn;

        } catch (SQLSyntaxErrorException se) {
            count++;
            if (count <= 1) {
                System.out.println("Database Created");
                return Database.createDatabase();
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return con;

    }



    

}
