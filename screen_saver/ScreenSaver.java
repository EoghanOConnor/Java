
/**
 * A ScreenSaver template for Challenge 5, drawing a rectangle, PacMan and text
 *
 * @author Eoghan O'Connor and Ciaran Hickey
 * Student I.D: 16110625 and 17204267
 * Description: This is a screen saver  project, when the project is run it produces
 * a screen that changes colours and shapes.
 *
 * Class Description: The ScreenSaver class creates 8 different objects with
 * different colours. They are are moved around they screen by changing x and y values
 * the background changes as the text moves across the screen.
 *
 * 
 * Theme:
 * the theme is "saved by the bell" this is a 90s T.v show that had random shapes
 * and colours as the intro for episodes.
 * 
 * @Last Modification: 20/04/2018
 */
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.Random;

public class ScreenSaver extends JPanel {

    // Declare instance variables and constants for objects
    private int xPac = 0;//position value x
    private int yPac = 200;//position value y
    private final int X_PAC_DELTA = 40; // Delta x Move for PAC/screen refresh
    private final int PAC_SIZE = 100;   // Diameter (bounding box size)
    private static int Colouring = 0;// state for which Colour to change to

    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        Random rng = new Random();      // Random Number Generator
        int screenWidth = getWidth();
        int screenHeight = getHeight();

        //Double to change the int Colouring
        double change = screenWidth - (xPac + PAC_SIZE);

        //Changing int colouring, to change the background colour
        if (change > 3 * screenWidth / 4) {
            Colouring = 1;
        }
        if (change < 3 * screenWidth / 4 && change > screenWidth / 2) {
            Colouring = 2;
        }
        if (change < screenWidth / 2 && change > screenWidth / 4) {
            Colouring = 3;
        }
        if (change < screenWidth / 4) {
            Colouring = 4;
        }

        Graphics2D g2 = (Graphics2D) g;
        //Date Text 
        g.setColor(Color.green);
        Font font2 = new Font("Calibri", Font.ITALIC, 32);
        String date = new SimpleDateFormat("yyyy/MM/dd.HH:mm:ss").format(new Date());
        g2.setFont(font2);
        g2.drawString(date, xPac, screenHeight - 75);

        //Name of Students text
        g.setColor(Color.red);//colour
        Font font = new Font("Calibri", Font.ITALIC, 24);//font
        g.setFont(font);      //setting font
        //Direction of text and size
        g.drawString("Eoghan O'Connor 16110625 & Ciaran Hickey 17204267", screenWidth - (xPac + PAC_SIZE), screenHeight - 100);

        //object 1
        g.setColor(Color.WHITE);
        int xPos = rng.nextInt(screenWidth);
        int yPos = rng.nextInt(screenHeight);
        g.drawRect(xPos, yPos,
                rng.nextInt(screenWidth - xPos), rng.nextInt(screenHeight - yPos));

        //object 2
        g2.setColor(Color.green);//colour
        g2.fillOval(xPac, yPos - 20, 30, 30);//size and direction 

        //Object 3
        g2.setColor(Color.pink);
        g2.fill3DRect(xPos - 100, yPos - 100, PAC_SIZE, PAC_SIZE, true);

        //Object 4
        g2.setColor(Color.GREEN);
        g2.fillRect(xPac, screenWidth - yPos, 50, 50);

        //Object5
        g2.setColor(Color.yellow);
        g2.drawOval(xPos, yPac, 40, xPos);

        //Object 6
        g2.setColor(Color.blue);
        g2.fillArc(xPos, yPac, 100, 75, 200, 270);

        //Object 7
        g.setColor(Color.red);
        g.fillArc(xPac, yPac, PAC_SIZE, PAC_SIZE, 360, 260);

        //Object 8
        g.setColor(Color.yellow);
        g.fillOval(xPos, yPos, 75, 75);
        xPac = (xPac < screenWidth) ? xPac + X_PAC_DELTA : 0;   // Update xPac

    }//end of paint

    // Create the panel above, add to a frame, display and refresh
    public static void main(String args[]) {
        JFrame frame = new JFrame("Screensaver");

        ScreenSaver screenSaverPanel = new ScreenSaver();
        screenSaverPanel.setBackground(Color.BLACK);

        frame.add(screenSaverPanel);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);    // maximise window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.addMouseListener(new ScreenSaverMouseListener());// Active the Mouse Listener

        // display frame
        do {  // Redraw window continuously, with a short delay.
            frame.repaint();
            try {
                //Switch statement to switch the colour of the back ground
                switch (Colouring) {
                    case 1://changing background to Black
                        screenSaverPanel.setBackground(Color.BLACK);
                        break;
                    case 2://changing background to orange
                        screenSaverPanel.setBackground(Color.orange);
                        break;
                    case 3://changing background to cyan
                        screenSaverPanel.setBackground(Color.CYAN);
                        break;
                    case 4://changing background to Light Gray
                        screenSaverPanel.setBackground(Color.LIGHT_GRAY);
                        break;
                }//end of switch statement

                Thread.sleep(500);
                // Delay the given ms
            }//end of catch
            catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }//end catch
        }//end do
        while (true);

    }//end main method
} // end class ScreenSaver

/**
 *
 * Class: Mouse Listener Description: This class closes down the JFrame when the
 * user clicks on the JFrame.
 */
class ScreenSaverMouseListener extends MouseAdapter {

    public void mouseClicked(MouseEvent e) {
        if (e.getSource() instanceof JFrame) {
            ((JFrame) e.getSource()).dispose();
            System.exit(0);

        }
    }//end of mouse Event
}//end of ScreenSaverMouseListener
