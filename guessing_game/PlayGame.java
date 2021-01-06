
/**
 *
 *Student Names: Eoghan O'Connor 
 * Student ID: 16110625 
 * Date of last Modification: 02-04-2018
 *
 * Description of Class: This is the Guessing game class were the player will try
 * to guess the number between 1-500.
 *
 * Summary : A Jframe is made with a JPanel, Jlabel, Jtextfield and JtextArea
 *
 * 1)The Jtextfield is used to take the input of the user.
 *
 * 2) The JLabel shows this input and gives a hint to user
 *
 * 3) The JtextArea shows previous guesses
 * 
 * 
 * TEST CASE: As this is a GUI it is impossible to run a test case but the following are 
 * test cases worth noting
 * 
 * Test case 1: User inputs 250 (Correct answer was 125) the users guess is added to the
 * previous guesses, A hint of "guess was too low guess higher" is prompted
 * 
 * Test Case 2: User inputs "A", this is catched by the exception and the warning please
 * enter a number between 1-500
 * 
 * Test Case 3: User inputs 750, this is prompts the warning message please
 * enter a number between 1-500
 *
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PlayGame implements ActionListener {

    // If you undo the code below the package starts acting the bollix when i run it.
    public int UserGuess; //User's guess
    public static Random rand = new Random(); // random number generator
    public static int Correct = rand.nextInt(501); // Creating the random number
    public int Count = 1; // Count how many guesses the user has taken

    JFrame Game = new JFrame("Guessing Game"); // the Play Game Jframe        
    JTextField Text = new JTextField(15); // Textfiled for entering Guess
    JLabel label = new JLabel("Please Enter Guesses in the small yellow box"); // Label for giving user a hint
    JPanel panel = new JPanel(); // panel used to place label, textarea and textfield on to Jframe
    JTextArea field = new JTextArea("Previous Guesses"); // the Textareaa for previous guesses

    public void actionPerformed(ActionEvent e) {
        //setting up JFrame
        Game.setSize(400, 200); // size of JFrame
        Game.setVisible(true);//making visible
        Game.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// closes window when X'd
        panel.setLayout(new FlowLayout()); // flowlayout
        panel.setBackground(Color.red);
        field.setEditable(false);// the TextArea isn't editable
        field.setPreferredSize(new Dimension(200, 350));// setting size of field
        field.setBackground(Color.green);
        Text.setBackground(Color.yellow);

        //Adding components to the Panel
        panel.add(Text);
        panel.add(label);
        panel.add(field);
        Game.add(panel);// adding panel to JFrame

        // Waiting for action to be preformed in Textfield
        Text.addActionListener(new ActionListener() {

            //If a guess is entered into the Jtextfield
            public void actionPerformed(ActionEvent e) {
                String input = Text.getText(); // turning the entry into a String
                

                try {
                    UserGuess = Integer.parseInt(input); //Turning string into int
                   if (UserGuess < 1 || UserGuess > 500) // Making sure guess is within game rules
                   {
                        String text = "Please enter a number between 1-500, thank you ";
                        JOptionPane.showMessageDialog(null, text, "NOT A VALID NUMBER", JOptionPane.PLAIN_MESSAGE);

                    }//end of try

                } //if user enters a lettter or character instead of digit
                catch (Exception ex) {
                    String text = "Please enter a number between 1-500, thank you ";
                    JOptionPane.showMessageDialog(null, text, "NOT A VALID NUMBER", JOptionPane.PLAIN_MESSAGE);

                }//end of catch

                //if user runs out of goes
                if (Count == 11) {
                    //this message will appear
                    
                    JOptionPane.showMessageDialog(null, "Hard luck, you didn't win"
                            + "\n If you were wondering the number was: " + Correct);
                      field.setText("Previous Guesses");//reseting Previous Guesses
                      UserGuess = 0;//Reseting UserGuess
                    Count = 0; //Resetting count
                    Correct = rand.nextInt(501); // New Number to guess
                    label.setText("Please Enter guessses in small box"); // Reseting hints
                    Text.setText("");// Resetting Textfiled
                    Game.dispose();// game will close
                  

                }//end of run out of  goes

                //Game responses for valid input
                if (UserGuess > 0 && UserGuess < 501) {
                    field.append("\n" + input); //  Putting entry into Previous guesses

                    //Iif user guesses correctly
                    if (UserGuess == Correct) {
                        // this message will appear
                        JOptionPane.showMessageDialog(null, "Well Done, you won!"
                                + "\n Your guess " + Correct + " \n You got it in " + Count + " goes.");
                         field.setText("Previous Guesses");//reseting Previous Guesses
                    Count = 0; //Resetting count
                    Correct = rand.nextInt(501); // New Number to guess
                    label.setText("Please Enter guessses in small box"); // Reseting hints
                    Text.setText("");// Resetting Textfiled
                    Game.dispose(); // game will close

                        
                    }//end of correct answer

                    // hint if guess was too low 
                    if (UserGuess < Correct) {
                        label.setText(+UserGuess + " is Too low, Try a Higher number " + Count + " Goes Taken");
                        Count = Count + 1; // incrementing guesses
                    }//end of  too low 

                    //hint if guess was too high
                    if (UserGuess > Correct) {
                        label.setText(+UserGuess + " is Too High, Try a lower number " + Count + "Goes Taken");
                        Count = Count + 1; // incrementing guesses

                    }//end of guess was too high

                }// end of valid input responses

            }
        });//end of listener

    }//end of action performed

}//end of class
