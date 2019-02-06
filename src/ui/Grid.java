package ui;
import logic.GameLogic;
import javax.swing.*;
import java.awt.*;

public class Grid extends JPanel {

    private  GameLogic grid ;
    public Grid(GameLogic grid) {
       this.grid= grid;
    }
    @Override
    protected void paintComponent(Graphics g) {
        int colms = 60;
        int rows = 60;
        int cellSize = 10;
        super.paintComponent(g);
        Graphics2D grf = (Graphics2D) g;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < colms; j++) {
                //Get the int[][] grid 2D array from the GameLogic and paint  it
                if (grid.getGrid()[i][j] == 1) {
                    grf.setColor(Color.BLACK);
                    grf.fillRect(i * cellSize, j * cellSize, cellSize, cellSize);
                } else if (grid.getGrid()[i][j] == 0) {
                    grf.setColor(Color.WHITE);
                    grf.fillRect(i * cellSize, j * cellSize, cellSize, cellSize);
                }
            }
            grf.setColor(Color.BLACK);
            //Divide rectangles by drawing lines between them
            for (int k = 0; k <= rows; k++) {
                grf.drawLine(0, k * cellSize, cellSize * rows, k * cellSize);
            }
            for (int l = 0; l <= colms; l++) {
                grf.drawLine(l * cellSize, 0, l * cellSize, cellSize * colms);
            }
        }
    }
    @Override
    public Dimension getPreferredSize() {
        //Set the preferred dimensions of the grid when jframe it's packed grid is not hidden
        return new Dimension(600,600);
    }
}
