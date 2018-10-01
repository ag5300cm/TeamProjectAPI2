package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class encyclopediaDB {

    public static void main(String[] args) {
        Connection conn = null;
        // TODO MAKE CONNECTION TO DATABASE
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:test:db");
            System.out.print("DB connected");



        } catch (Exception e) {
            System.out.print(e);
        };
        // TODO CREATE TABLE IF NOT EXIT

        // Extra QUERY THE DATABASE FOR SUBJECT INFORMATION

        // TODO INSERT SUBJECT INFORMATION INTO TABLE

        // Extra DELETE SUBJECT INFORMATION FROM TABLE
    }

    public void ConnectionOne() {

    }
}
