import javax.swing.*;
//import javafx.*;
//import java.awt.*;


/**
 * Created by ag5300cm on 9/27/2018.
 */
public class APIsearch extends JFrame {
    private JTextField textField1;
    private JButton searchButton;
    private JButton exitButton;
    private JButton saveButton;
    private JTextArea textArea1;
    private JLabel PIctureHere;
    private JPanel mainPanel;
   // private ImageIcon image1;


    APIsearch() {

        setContentPane(mainPanel);
        pack();
        //setSize(1600, 1000);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        ImageIcon image1 = new ImageIcon(getClass().getResource("WarAirplanes.jpg"));
        PIctureHere.setIcon(image1);


        //PIctureHere = new JLabel(getClass().getResource("WarAirplanes.jpg"));
        //add(PIctureHere);
    }
}
