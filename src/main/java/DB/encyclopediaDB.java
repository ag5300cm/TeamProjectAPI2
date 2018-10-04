package DB;


import java.sql.Connection;  // could use import java.sql.*; for everything
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.ResultSet; // for returning data, I believe

public class encyclopediaDB {

    //static Connection conn = null;

//    public static Connection connect() {
//        try {
//            Class.forName("org.sqlite.JDBC");
//            conn = DriverManager.getConnection("jdbc:sqlite:test:db");
//            System.out.print("DB connected");
//            return conn;
//        } catch (SQLException e) {
//            e.printStackTrace(System.out);
//            return null;
//        }
//    }

    public static void ConnectAndCreateTable() {

        // MAKE CONNECTION TO DATABASE
        Connection conn = null;
        try {
            //Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:test:db";
            conn = DriverManager.getConnection(url);
            System.out.print("DB connected");

            // CREATE TABLE IF NOT EXIT
            String tableName = "MyTable";  // Change table name here
            String sqlCreateTable = "CREATE TABLE IF NOT EXISTS " + tableName
                    + " (SearchWord  CHAR(40),"  // Todo Should Char be TEXT ????,, Should A "\n" be at the end of each one???
                    + "  TextInfo    VARCHAR(5000),"  // Increase Number here to hold more wiki data
                    + "  Picture     BLOB )";

            Statement statementCT = conn.createStatement();
            statementCT.execute(sqlCreateTable);



            // TODO INSERT SUBJECT INFORMATION INTO TABLE


        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        };


        // TODO QUERY THE DATABASE FOR SUBJECT INFORMATION

        // Extra DELETE SUBJECT INFORMATION FROM TABLE
    }

}


