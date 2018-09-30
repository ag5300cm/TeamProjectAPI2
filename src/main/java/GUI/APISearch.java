package GUI;

import javax.swing.*;


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
    private ImageIcon image1;

    public APISearch() {

        setContentPane(mainPanel);
        pack();
        //setSize(1600, 1000);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        //ImageIcon image1 = new ImageIcon(getClass().getResource("WarAirplanes.jpg"));
        //pictureLabel.setIcon(image1);


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
