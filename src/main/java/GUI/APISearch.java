package GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Blob;

import API.DescriptionAPI;
import API.ImageAPI;
import DB.encyclopediaDB;
/**
 * Created by ag5300cm on 9/27/2018.
 */
public class APISearch extends JFrame {
    private JTextField searchTextField;
    private JButton searchButton;
    private JButton exitButton;
    private JButton saveButton;
    private JTextArea descriptionTextArea;
    private JLabel pictureLabel;
    private JPanel mainPanel;
    private JLabel subjectWikiUrlLabel;

    public APISearch() {

        setContentPane(mainPanel);

        // Will load image below this is what we used for testing  TODO Chage image1 to what is API searched
        ImageIcon image1 = new ImageIcon(("WarAirplanes.jpg"));  // This gets the image saved in the program, will need to be relaced with API search
        Image newImage1 = image1.getImage().getScaledInstance(480, 480, Image.SCALE_DEFAULT);  // Did work for scaling, Change image size here
        ImageIcon imageIcon = new ImageIcon(newImage1);  // Changing back to imageIcon so it will work with Jlabel
        pictureLabel.setIcon(imageIcon);  // Setting image on GUI

        pack();
        setSize(1600, 1000);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        configureEventHandlers();
    }

    private void configureEventHandlers() {


        //EVENT HANDLER TO HANDLE SEARCH BUTTON
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {

                    String searchText = searchTextField.getText(); // Getting the input text

                    //TODO DB method to check if searchText is in table
                    // Return Subject object if searchText is in table
                    // Otherwise return 0
                        // If 0 call APIs

//                  String displayText = encyclopediaDB.searchButtonPressed(searchText);  // used to check if already searched.
//                  descriptionTextArea.setText(displayText);  // Making the data already searched and saved displayed

                    //TODO set picture to pictureLabel
                  String imageUrl = ImageAPI.getImageOfSubject(searchText);
//                  pictureLabel.setIcon();
                    URL url=new URL(imageUrl);
                    try {
//                    URLConnection conn = url.openConnection();
                        BufferedImage c = ImageIO.read(url);
                        ImageIcon newImage = new ImageIcon(c);
                        pictureLabel.setIcon(newImage);
                        descriptionTextArea.setText(DescriptionAPI.getDescriptionOfSubject(searchText));
                    }catch (MalformedURLException c){
                        c.printStackTrace();
                    }catch (IOException c){
                        c.printStackTrace();
                    }
                    String urlString = "https://en.wikipedia.org/wiki/" + searchText;

                    //TODO make urlString a hyperlink to wiki page
                    subjectWikiUrlLabel.setText("Read more about " + searchText + " on Wikipedia: " + urlString);

                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }
        });


        // EVENT HANDLER TO HANDLE SAVE BUTTON
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //TODO create a subject object
                // Subject subject = new Subject(searchText, imageUrl, subjectDescription)

                String searchText = searchTextField.getText();
                ImageIcon image1 = new ImageIcon(("WarAirplanes.jpg")); /// used for testing and failed.
                Icon saveMePic = pictureLabel.getIcon() ;   //Todo attach API search data for Image Here Please, maybe change to ImageIcon or other thing
                String textData = descriptionTextArea.getText();

                // TODO move this elsewhere does not need to create DB and table everytime
                encyclopediaDB.ConnectAndCreateTable();  // Will create database if not already made, same with table

                encyclopediaDB.saveButtonPressed(searchText, textData, image1);  // Can currently save two out of three

            }
        });


        // EVENT HANDLER TO HANDLE EXIT BUTTON
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);  // Should work for closing the program
            }
        });

    }
}
