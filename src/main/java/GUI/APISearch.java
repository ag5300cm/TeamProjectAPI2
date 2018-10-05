package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Blob;

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

    public APISearch() {

        setContentPane(mainPanel);

        // Will load image below this is what we used for testing  TODO Chage image1 to what is API searched
        ImageIcon image1 = new ImageIcon(("WarAirplanes.jpg"));  // This gets the image saved in the program, will need to be relaced with API search
        Image newImage1 = image1.getImage().getScaledInstance(480, 480, Image.SCALE_DEFAULT);  // Did work for scaling, Change image size here
        ImageIcon imageIcon = new ImageIcon(newImage1);  // Changing back to imageIcon so it will work with Jlabel
        pictureLabel.setIcon(imageIcon);  // Setting image on GUI

        pack();
        //setSize(1600, 1000);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        //pictureLabel = new JLabel(getClass().getResource("WarAirplanes.jpg"));
        //add(pictureLabel);

        configureEventHandlers();

    }

    private void configureEventHandlers() {


        //EVENT HANDLER TO HANDLE SEARCH BUTTON
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String searchText = searchTextField.getText();
                // TODO use searchText for API usages and get info back

            }
        });


        // EVENT HANDLER TO HANDLE SAVE BUTTON
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String searchText = searchTextField.getText();
                Icon saveMePic = pictureLabel.getIcon() ;   //Todo attach API search data for Image Here Please
                String textData = descriptionTextArea.getText();


                encyclopediaDB.ConnectAndCreateTable();  // Will create database if not already made, same with table
                // TODO work on connecting data to database
                encyclopediaDB.saveButtonPressed(searchText, textData, saveMePic );

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
