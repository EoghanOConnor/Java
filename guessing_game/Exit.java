
/**
 *
 *Student Names: Eoghan O'Connor 
 * Student ID: 16110625 
 * Date of last Modification: 02-04-2018
 *
 * Description of Class: This is the exit screen where, the game will close down
 * completely and display a thank you for coming message
 *
 * Summary : JOptionRane is used to show that the game is being closed down
 * Them then package is closed down
 *
 *
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class Exit implements ActionListener {
//Action Performed

    public void actionPerformed(ActionEvent e) {
        //Message displayed
        JOptionPane.showMessageDialog(null, "Thanks for playing The Guessing Game, see you soon!");
        System.exit(0);//System closed down
    }//end of action performed

}//end of class
