package DB;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.sql.*;

public class encyclopediaDB {

    public static Connection conn = null;

    public static Connection connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:test:db");  // Using driver Manager to connect to database
            System.out.print("DB connected");  // letting me know connect, can delete later
            return conn;
        } catch (Exception e) {
            e.printStackTrace(System.out);  // Incase it breaks down will lead me to the problem
            return null;
        }
    }

    public static void ConnectAndCreateTable() {

        // MAKE CONNECTION TO DATABASE
        conn = null;
        try {
            //Class.forName("org.sqlite.JDBC");
            //String url = "jdbc:sqlite:test:db";
            //conn = DriverManager.getConnection(url);
            conn = connect();
            //System.out.print("DB connected");

            // CREATE TABLE IF NOT EXIT
            String tableName = "MyTable";  // Change table name here
            String sqlCreateTable = "CREATE TABLE IF NOT EXISTS " + tableName
                    + " (SearchWord  CHAR(40),"  // Todo Should Char be TEXT ????,, Should A "\n" be at the end of each one???
                    + "  TextInfo    VARCHAR(5000),"  // Increase Number here to hold more wiki data
                    + "  Picture     BLOB )";

            try {
                Statement statementCT = conn.createStatement();  // Creating a blank statement, can be added to
                statementCT.execute(sqlCreateTable);  // adding to blank statement and executing it (or making table)
            }catch (NullPointerException npe) {
                System.out.println("Error : " + npe);
            }

        } catch (SQLException e) {  // Yo in case its broke
            System.out.print(e.getMessage());
        }finally {  // Should close the connection
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        };
    }

    // TODO INSERT SUBJECT INFORMATION INTO TABLE
    public static void saveButtonPressed(String searchTerm, String textInfoAPI, Icon pictureToSave) {

        conn = null;
        String tableName = "MyTable";  // Change table name here
        //Blob pictureSave = pictureToSave;  //TODO change Icon or ImageIcon to Blob
        try {
            conn = connect();
            String saveMeData = "INSERT INTO " + tableName + " (SearchWord, TextInfo, Picture) " +
                    " VALUES(?,?,?)";

            PreparedStatement prepAndGo = conn.prepareStatement(saveMeData);
            prepAndGo.setString(1, searchTerm);
            prepAndGo.setString(2, textInfoAPI);

            ByteArrayOutputStream baos = null;  //https://stackoverflow.com/questions/20961065/converting-image-in-memory-to-a-blob  (Code from)
            try {
                baos = new ByteArrayOutputStream();
                //Image image2 = new Image(("WarAirplanes.jpg"));
                //ImageIcon picSaveMe = new ImageIcon(pictureToSave);
                //ImageIO.write(picSaveMe, "jpg", baos);
            } catch (Exception ex) {
                System.out.print(ex);
            } finally {
                try {
                    baos.close();
                } catch (Exception e) {
                }
            }
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());

            prepAndGo.setBlob(3, bais);  //  TODO find a way to put blob here
            prepAndGo.executeUpdate();

        } catch (Exception eee) {
            System.out.print("Couldn't Save: " + eee);
        }
    }

    // TODO QUERY THE DATABASE FOR SUBJECT INFORMATION

    // Extra DELETE SUBJECT INFORMATION FROM TABLE


}


