
/**
 *
 *Student Names: Eoghan O'Connor 
 * Student ID: 16110625 
 * Date of last Modification: 02-04-2018
 *
 * Description of Class: This is the main Menu of the game the user has 3 options
 * to play the game, How to play the game or Exit the game.
 *
 * Summary : Jframe, Jpanel, Jbuttons are used to create this window
 * 1) the JFrame is prompted first when the code is run.
 * 2) the JPanel is added to the Jframe and displays the 3 buttons as the Users
 * options
 * 3) These three buttons navigate the program by showing the User Where to play the game,
 * how to play or exit the game.
 *
 *
 *
 *
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main_Menu {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Jframe of the main mneu
        JFrame Menu1 = new JFrame("Guess Game");//Naming window
        Menu1.setSize(new Dimension(200, 300));//setting size
        Menu1.setVisible(true);//making visible
        Menu1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//closing window if x'd
        JPanel panel = new JPanel();//creating Jpanel
        panel.setSize(100, 200);//setting size
        panel.setLayout(new FlowLayout()); // setting a flow layout
        Menu1.add(panel);//adding Jpanel to the Jframe
        panel.setBackground(Color.MAGENTA); //Setting colour to Magenta

        // Creating play game button
        JButton PlayGame = new JButton("Play Game");
        //Creating Exit option
        JButton Exit = new JButton("EXIT");
        //Creating Help option
        JButton HowTo = new JButton("How to Play Guessing Game");
        
        panel.add(PlayGame);//adding to panel
       //adding Help option
        panel.add(HowTo);
        //adding Exit option
        panel.add(Exit);
        
        PlayGame.addActionListener(new PlayGame());//Running Play game Option
        Exit.addActionListener(new Exit());
        HowTo.addActionListener(new HowTo());
    }//End of Main method

}//end of Class
