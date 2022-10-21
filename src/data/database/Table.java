package data.database;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author root
 */
public class Table {

    private final String name;
    private final List<String> fields = new ArrayList<>();
    private String primaryKey;

    public Table(String name) {
        this.name = name;
    }

    public Table addField(String field) {
        fields.add(field);
        return this;

    }

    public Table setPK(String primaryKey) {
        this.primaryKey = primaryKey;

        return this;
    }

    static void addToDatabase(Table table) {
        String url = DbConnection.URL + DbConnection.DB_NAME;
        String user = DbConnection.USERNAME;
        String pass = DbConnection.PASS;

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

    static void createAll() {
        Table user = new Table("users")
                .addField("username varchar(50) not null")
                .addField("password varchar(50) not null")
                .addField("name varchar(100) not null")
                .addField("email varchar(50) not null")
                .addField("role varchar(10) not null default 'admin'")
                .addField("isenable varchar(5) not null default 'false'")
                .addField("created_at timestamp NOT NULL DEFAULT current_timestamp()")
                .addField("updated_at timestamp NOT NULL DEFAULT current_timestamp()")
                .setPK("username");

        Table employee = new Table("employee")
                .addField("id varchar(12) not null")
                .addField("firstname varchar(50) not null")
                .addField("lastname varchar(50) not null")
                .addField("middlename varchar(50)")
                .addField("name_extension varchar(10)")
                .addField("gender varchar(20) not null")
                .addField("birthdate date not null")
                .addField("place_of_birth varchar(255)")
                .addField("image text")
                .addField("position_id int(11) not null")
                .addField("created_at timestamp NOT NULL DEFAULT current_timestamp()")
                .addField("updated_at timestamp NOT NULL DEFAULT current_timestamp()")
                .setPK("id");

        Table employeeInfo = new Table("employee_info")
                .addField("id int(11) not null auto_increment")
                .addField("employee_id varchar(12) not null")              
                .addField("civil_status varchar(50) ")
                .addField("citizenship varchar(50) ")
                .addField("height varchar(10) ")
                .addField("weight varchar(10) ")
                .addField("blood_type varchar(5)")
                .addField("gsis varchar(50)")
                .addField("sss varchar(50)")
                .addField("phil_health varchar(50)")
                .addField("pag_ibig varchar(50)")
                .addField("tin varchar(50)")
                .addField("cellphone_no varchar(50)")
                .addField("telephone_no varchar(20)")
                .addField("email varchar(20)")
                .addField("current_address text")
                .addField("permanent_address text")
                .setPK("id");

        Table position = new Table("positions")
                .addField("id int(11) not null auto_increment")
                .addField("name varchar(200) not null")
                .addField("category varchar(50) not null")
                .setPK("id");
        
        Table serviceCredits = new Table("service_credits")
                .addField("id int(11) not null auto_increment")
                .addField("order_no varchar(50) not null")
                .addField("memorandum varchar(255) not null")
                .addField("no_of_days int(10) not null")
                .addField("created_at timestamp NOT NULL DEFAULT current_timestamp()")
                .addField("updated_at timestamp NOT NULL DEFAULT current_timestamp()")
                .setPK("id");
        
        Table employeeAndServiceCredits = new Table("employee_and_service_credits")
                .addField("employeeId")
                .addField("service_credits_id");

       

        addToDatabase(user);
        addToDatabase(employee);
        addToDatabase(employeeInfo);
        addToDatabase(position);
        addToDatabase(serviceCredits);
  

    }

    static String tableToSqlString(Table table) {
        String sql = "create table " + table.name;
        boolean hasPrimaryKey = table.primaryKey != null;

        List<String> fields = table.fields;

        sql = sql.concat("(");

        int i = 0;
        for (String str : fields) {

            sql = sql.concat(str);
            if (i == fields.size() - 1 && !hasPrimaryKey) {
                break;
            }

            sql = sql.concat(",");
            i++;

        }

        if (hasPrimaryKey) {
            sql = sql.concat("primary key(" + table.primaryKey + ")");
        }

        sql = sql.concat(");");
        System.out.println(sql);
        return sql;

    }

}
