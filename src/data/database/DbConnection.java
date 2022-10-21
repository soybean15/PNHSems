package data.database;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLSyntaxErrorException;

/**
 *
 * @author root
 */
public abstract class DbConnection {

    static Connection conn = null;
    static final String DB_NAME = "db_pnhsems";
    static final String URL = "jdbc:mysql://localhost:3306/";
    static final String USERNAME = "root";
    static final String PASS = "";
    static int count = 0;

    public static Connection createDatabase() {
        Connection con;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/", USERNAME, PASS);
            PreparedStatement pst = con.prepareStatement("create DATABASE " + DB_NAME + ";");
            pst.execute();
            Table.createAll();

        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return getConnection();
    }

    public static Connection getConnection() {

        Connection con = null;
        try {
            if (conn == null) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection(URL + DB_NAME, USERNAME, PASS);
                System.out.println("Connected");

            }
            con = conn;

        } catch (SQLSyntaxErrorException se) {
            count++;
            if (count <= 1) {
                System.out.println("Database Created");
                return createDatabase();
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return con;

    }



    public static Connection dropDatabase() {
        Connection con;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/", "root", "");
            PreparedStatement pst = con.prepareStatement("drop DATABASE " + DB_NAME + ";");
            pst.execute();

        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

}
