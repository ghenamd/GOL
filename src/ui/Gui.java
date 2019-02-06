package ui;
import javax.swing.*;
import java.awt.*;

public class Gui {
     private Grid grid;
     public static final int WIDTH =600;
     public static final int HEIGHT =600;

    public Gui(Grid grid) {
        this.grid = grid;
    }

    public void createUi(){
        JFrame frame = new JFrame();
        frame.setSize(WIDTH, HEIGHT);
        frame.setLocation(500, 25);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().add(grid);
        frame.setVisible(true);
        //Wraps content
        frame.pack();
    }
}
