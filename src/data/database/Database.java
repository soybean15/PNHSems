/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.database;

import static data.database.DbConnection.getConnection;
import static data.database.Table.tableToSqlString;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author root
 */
public class Database {

    static Connection conn = null;
    static final String DB_NAME = "db_pnhsems";
    static final String URL = "jdbc:mysql://localhost:3306/";
    static final String USERNAME = "root";
    static final String PASS = "";

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

    public static Connection createDatabase() {
        Connection con;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/", USERNAME, PASS);
            PreparedStatement pst = con.prepareStatement("create DATABASE " + DB_NAME + ";");
            pst.execute();

            List<Table> tables = Table.createAll();

            addToDatabase(tables);

        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return getConnection();
    }

    static void addTable(Table table) {
        String url = URL + DB_NAME;
        String user = USERNAME;
        String pass = PASS;

        String sql = tableToSqlString(table);
        try {
            Connection con = DriverManager.getConnection(url, user, pass);
            PreparedStatement pst = con.prepareStatement(sql);
            pst.execute();
            System.out.println("new table created");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    static void addToDatabase(List<Table> tables) {
        for (Table table : tables) {
            addTable(table);
        }
    }

}
