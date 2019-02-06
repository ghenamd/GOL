package ui;
import logic.GameLogic;
import utils.Const;
import javax.swing.*;
import java.awt.*;
import static utils.Const.*;

public class Grid extends JPanel {

    private GameLogic grid;

    public Grid(GameLogic grid) {
        this.grid = grid;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D grf = (Graphics2D) g;
        for (int i = 0; i < COLMS; i++) {
            for (int j = 0; j < ROWS; j++) {
                //Get the int[][] grid 2D array from the GameLogic and paint  it
                if (grid.getCurrentGrid()[i][j] == 1) {
                    grf.setColor(Color.BLACK);
                    grf.fillRect(i * CELL_SIZE, j * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                } else if (grid.getCurrentGrid()[i][j] == 0) {
                    grf.setColor(Color.WHITE);
                    grf.fillRect(i * CELL_SIZE, j * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                }
            }
            grf.setColor(Color.BLACK);
            //Divide rectangles by drawing lines between them
            for (int k = 0; k <= ROWS; k++) {
                grf.drawLine(0, k * CELL_SIZE, Const.WIDTH, k * CELL_SIZE);
            }
            for (int l = 0; l <= COLMS; l++) {
                grf.drawLine(l * CELL_SIZE, 0, l * CELL_SIZE, Const.HEIGHT);
            }
        }
    }

    @Override
    public Dimension getPreferredSize() {
        //Set the preferred dimensions of the grid when jframe it's packed grid is not hidden
        return new Dimension(Const.WIDTH, Const.HEIGHT);
    }
}
