import javax.swing.*;
import java.awt.*;
import java.util.Random;

import static jdk.nashorn.internal.objects.NativeMath.random;

public class Grid extends JPanel {
    private static int colms = 55;
    private static int rows = 55;
    private static int[][] grid ;


    private static int alive = 1;
    private static int dead = 0;
    private int cellSize = 10;

    public Grid() {
        grid= new int[rows][colms];
        init();
    }



    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D grf = (Graphics2D) g;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < colms; j++) {


                if (grid[i][j] == 1) {

                    grf.setColor(Color.BLACK);
                    grf.fillRect(i * cellSize, j * cellSize, cellSize, cellSize);
                } else if (grid[i][j] == 0) {

                    grf.setColor(Color.WHITE);
                    grf.fillRect(i * cellSize, j * cellSize, cellSize, cellSize);
                }
            }
            grf.setColor(Color.BLACK);
            //Divide rectangle by drawing lines between them
            for (int k = 0; k <= rows; k++) {
                grf.drawLine(0, k * cellSize, cellSize * rows, k * cellSize);
            }
            for (int l = 0; l <= colms; l++) {
                grf.drawLine(l * cellSize, 0, l * cellSize, cellSize * colms);
            }
        }
    }

    public static void changeGridState() {
        int[][] nextGrid = new int[rows][colms];
        for (int i = 1; i < rows - 1; i++) {
            for (int j = 1; j < colms - 1; j++) {
                int neighbours = countCells(grid, i, j);
                if (grid[i][j] == alive && (neighbours < 2 || neighbours > 3)) {
                    nextGrid[i][j] = dead;
                }
                if (grid[i][j] == alive && (neighbours == 3 || neighbours == 2)) {
                    nextGrid[i][j] = alive;
                }
               if (grid[i][j] == dead && neighbours == 3) {
                    nextGrid[i][j] = alive;
                }

            }
        }
       grid= nextGrid;
    }

  public    void init() {
      Random random = new Random();
        for (int i =1;i < colms-1;i++) {
            for (int j =1;j < rows-1;j++) {
                grid[i][j] = random.nextInt(2);
            }
        }
    }
    private static int countNeighbours(int[][] grid, int x, int y) {

        int neighbors = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                neighbors += grid[x+i][y+j];
            }
        }

       neighbors -= grid[x][y];
        return neighbors;
    }

    private static int countCells(int[][] grid, int i, int j) {
        int sum = 0;
        if (grid[i - 1][j] == alive) {
            sum++;
        }
        if (grid[i + 1][j] == alive) {
            sum++;
        }
        if (grid[i - 1][j - 1] == alive) {
            sum++;
        }
        if (grid[i][j - 1] == alive) {
            sum++;
        }
        if (grid[i][j + 1] == alive) {
            sum++;
        }
        if (grid[i + 1][j - 1] == alive) {
            sum++;
        }
        if (grid[i + 1][j + 1] == alive) {
            sum++;
        }
        if (grid[i - 1][j + 1] == alive) {
            sum++;
        }
        return sum;
    }
}
