package GUI;

import javax.swing.*;
import java.awt.*;


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

        // Will load image below this is what we used for testing, we will find a way to scale it.
        ImageIcon image1 = new ImageIcon(("WarAirplanes.jpg"));
        //Image newImage1 = image1.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);  // Did not quite work for scaling
        pictureLabel.setIcon(image1);

        pack();
        //setSize(1600, 1000);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        //pictureLabel = new JLabel(getClass().getResource("WarAirplanes.jpg"));
        //add(pictureLabel);

        configureEventHandlers();

    }

    private void configureEventHandlers() {


        //TODO EVENT HANDLER TO HANDLE SEARCH BUTTON


        //TODO EVENT HANDLER TO HANDLE SAVE BUTTON


        //TODO EVENT HANDLER TO HANDLE EXIT BUTTON
    }
}
