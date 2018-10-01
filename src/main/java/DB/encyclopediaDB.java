package DB;

import java.sql.Connection;
import java.sql.DriverManager;

public class encyclopediaDB {



    public static void main(String[] args) {

        Connection c = null;
        // TODO MAKE CONNECTION TO DATABASE
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test:db");
            System.out.print("DB connected");


        } catch (Exception e) {
            System.out.print(e);
        };

        // TODO CREATE TABLE IF NOT EXIT


        // TODO QUERY THE DATABASE FOR SUBJECT INFORMATION


        // TODO INSERT SUBJECT INFORMATION INTO TABLE


        // TODO DELETE SUBJECT INFORMATION FROM TABLE

    }
}
