package ui;
import javax.swing.*;
import java.awt.*;
import static utils.Const.*;

public class Gui {

    private Grid grid;
    public Gui(Grid grid) {
        this.grid = grid;
    }

    public void createUi() {
        JFrame frame = new JFrame(GAME_TITLE);
        frame.setSize(WIDTH, HEIGHT);
        frame.setBackground(Color.WHITE);
        frame.setLocation(400, 25);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(grid);
        frame.setResizable(false);
        frame.setVisible(true);
        //Wraps content
        frame.pack();
    }
}
