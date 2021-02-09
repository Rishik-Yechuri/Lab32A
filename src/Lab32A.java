import java.awt.*;
import java.awt.event.*;

public class Lab32A {
    public static void main(String args[]) {
        // Do not change this method
        Windows win = new Windows();
        win.setSize(1000, 750);
        win.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        win.show();
    }
}

class Windows extends Frame {
    //Draws squares from left to right recursively,with each square's length being 25% smaller
    public static void drawSquare(Graphics g, int x, int y, int length,int[] initialValues)
    {
        //Keeps going if it hasn't reached the edge,and the square isn't too small
        if(x+length < 1000 && length >= 4){
            //Draws the square
            g.fillRect(x, y, length, length);
            //Moves the x position to the right
            x+=10+length;
            //Shrinks the side length
            length*=.75;
            /*Adds initialValues[0](The length of the original square) and
            initialValues[0](The y position of the original square). It then
            subtracts the length to get the final y position. This is done
            so that the bottom of each square is lined up.*/
            y = initialValues[0] + initialValues[1] - length;
            //Calls itself again
            drawSquare(g,x,y,length,initialValues);
        }
    }
    //The same as drawSquare() but with a few minor tweaks
    public static void drawReverseSquare(Graphics g, int x, int y, int length)
    {
        //Checks that it hasn't reached the left edge,and the square isn't too small
        if(x-length > 0 && length >= 4){
            g.fillRect(x, y, length, length);
            //Shrinks length before doing x position calculation
            length*=.75;
            //Using the smaller value for length,it calculates the new x position
            x-=(length+10);
            drawReverseSquare(g,x,y,length);
        }
    }

    public void paint(Graphics g)
    {
        //Calls drawSquare,with values set(int[] array stores length of first square,and original y position)
        drawSquare(g, 0, 100, 200,new int[]{200,100});
        //Calls drawReverseSquare with values
        drawReverseSquare(g, 800, 500, 200);
    }
}