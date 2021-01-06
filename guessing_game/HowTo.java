/**
 *
 *Student Names: Eoghan O'Connor 
 * Student ID: 16110625 
 * Date of last Modification: 02-04-2018
 *
 * Description of Class: This is the Help section or how to play section
 * The package will inform the user of the rules and how to play simply
 *
 * Summary : a JFrame, Jpanel , Jlabel and a JButton are used.
 *
 * 1) The Jframe produces a new window
 * 2) the JLabel shows the rules of the game
 * 3) The button closes down the window, leaving the user with the main menu
 * 4) The JPanel adds the Jlabel and the JButton onto the JFrame
 *
 */
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HowTo implements ActionListener {

    public void actionPerformed(ActionEvent e) {
        //Jframe for the How to PLay window
        final JFrame HTP = new JFrame("How To Play"); //setting name
        HTP.setDefaultCloseOperation(HTP.DISPOSE_ON_CLOSE); // close window if x'd
        HTP.setVisible(true);//making visible
        HTP.setSize(500, 500); // setting size

        //text displayed on game rules
        JLabel text = new JLabel("<html> RULES of Guessing Game "
                + "<br/> <br/> A random Number is selected between 1 and 500 "
                + "<br/> Your objective is to guess this number in 9 goes"
                + "<br/> <br/> Hint: If you're Clever Strategic it will only take you a max of 9 goes"
        );//end of Jlabel

        //Panel and adding label and adding panel to JFrame
        JPanel panel = new JPanel();
        HTP.add(panel);
        panel.add(text);
        HTP.getContentPane().add(panel, BorderLayout.CENTER);
        panel.add(text, BorderLayout.CENTER);

        //Return button Setting name, location and adding to panel
        JButton Return = new JButton("Return");
        panel.add(Return);
        HTP.add(Return, BorderLayout.SOUTH); // setting location

        //if the return button is used it will close the windown
        Return.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                HTP.dispose();

            }//end of action performed for button
        });// end of action listener for button

    }//end of action performed 

}//End of class
