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
            //System.out.print("DB connected");  // letting me know connect, can delete later
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

            conn = connect();  // getting connection method
            //System.out.print("DB connected");  // used for testing

            // CREATE TABLE IF NOT EXIT
            String tableName = "MyTable";  // Change table name here
            String sqlCreateTable = "CREATE TABLE IF NOT EXISTS " + tableName
                    + " (SearchWord  CHAR(40),"  //  The word or words used to search will go in here.
                    + "  TextInfo    VARCHAR(5000),"  // Increase Number here to hold more wiki data
                    + "  Picture     BLOB )";

            try {
                Statement statementCT = conn.createStatement();  // Creating a blank statement, can be added to
                statementCT.execute(sqlCreateTable);  // adding to blank statement and executing it (or making table)
            }catch (NullPointerException npe) {
                System.out.println("Error : " + npe);  // Incase of connection or table creation problem
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

    // TODO INSERT Picture INTO TABLE if possible
    public static void saveButtonPressed(String searchTerm, String textInfoAPI, ImageIcon pictureToSave) {

        conn = null;
        String tableName = "MyTable";  // Change table name here
        //Blob pictureSave = pictureToSave;  //TODO change Icon or ImageIcon to Blob
        try {
            conn = connect();
            // Below is what to use if can insert picture into table
//            String saveMeData = "INSERT INTO " + tableName + " (SearchWord, TextInfo, Picture) " +
//                    " VALUES(?,?,?)";
            // Current string only inserts Search term and searched texted
            String saveMeData = "INSERT INTO " + tableName + " (SearchWord, TextInfo) " +
                    " VALUES(?,?)";

            PreparedStatement prepAndGo = conn.prepareStatement(saveMeData); // Making a statement to go in the table
            prepAndGo.setString(1, searchTerm);  // Setting each variable
            prepAndGo.setString(2, textInfoAPI);


            // TODO find way to save images.

            ByteArrayOutputStream stream = new ByteArrayOutputStream();  //https://stackoverflow.com/questions/20961065/converting-image-in-memory-to-a-blob  (Code from)



            //prepAndGo.setBlob(3, pictureToSave);  //  TODO find a way to put blob here
            prepAndGo.executeUpdate();  // Inserting in to table
            conn.close();  // ending connection like good proper etiquette, gonna' have tea now.

        } catch (Exception eee) {
            System.out.print("Couldn't Save: " + eee);
            eee.printStackTrace(System.out);  // Helping me find the problem
        }
    }

    // QUERY THE DATABASE FOR SUBJECT INFORMATION
    public static String searchButtonPressed(String searchTerm) {

        String returnMeString = "";  // This should cause it to return blank if no match found, then API search can do there thing.

        try {
            conn = connect();  // Making a connection and connection variable
            String query = "SELECT * FROM Mytable";  // Having a statment that will search the whole database,
            // could make it SearchWord instead of *, but then would need research if a match would be made.
            Statement statementSQL = conn.createStatement(); // Preparing a blank statement
            ResultSet rs = statementSQL.executeQuery(query);  // getting a result set from the sqlite database

            while (rs.next()) {  // Going through the result set line by line
                String searchTermPrintMe = rs.getString("SearchWord");
                String TextInfoPrintMe = rs.getString("TextInfo");
                //Blob picturePrintMe = rs.getBlob("Picture");

                if (searchTerm.equalsIgnoreCase(searchTermPrintMe)) {  // seeing if it matches the current search term
                    returnMeString = TextInfoPrintMe;  // If match, will get previous data
                }

                System.out.print(searchTermPrintMe + "  " + TextInfoPrintMe);  // This should print of the info to show table working, can delete later
            }

            conn.close();
        } catch (SQLException sqlE) {
            sqlE.printStackTrace(System.out);  // To help me find the problem
        }

        return returnMeString; // returning text data, will have to change to tuple of can get picture working.
    }

    // Extra DELETE SUBJECT INFORMATION FROM TABLE


}


