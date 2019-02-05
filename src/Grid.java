import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Grid extends JPanel {
    private static int colms = 55;
    private static int rows = 55;
    private static int[][] grid=new int[rows][colms];
    private static int[][] nextGrid= new int[rows][colms];

    private static int alive = 1;
    private static int dead = 0;
    private int cellSize = 10;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Random random = new Random();
        Graphics2D grf = (Graphics2D) g;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < colms; j++) {
                int aliveOrDead = random.nextInt(2);
                grid[i][j] = aliveOrDead;
                if (aliveOrDead == 1) {

                    grf.setColor(Color.BLACK);
                    grf.fillRect(i * cellSize, j * cellSize, cellSize, cellSize);
                } else if (aliveOrDead == 0) {

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

    public static int[][] changeGridState() {
        for (int i = 1; i < rows-1 ; i++) {
            for (int j = 1; j < colms-1 ; j++) {
                int neighbours = countNeighbours(grid, i, j);
//                if (grid[i][j] == alive && (neighbours < 2 || neighbours > 3)) {
//                    nextGrid[i][j] = dead;
//                }
//               else if (grid[i][j] == alive && (neighbours == 3 || neighbours == 2)) {
//                    nextGrid[i][j] = alive;
//                }
//                else if (grid[i][j] == dead && neighbours == 3) {
//                    nextGrid[i][j] = alive;
//                }
//                else {
//                    nextGrid[i][j] = grid[i][j];
//                }

                if      ((grid[i][j] == 1) && (neighbours <  2)) nextGrid[i][j] = 0;
                else if ((grid[i][j] == 1) && (neighbours >  3)) nextGrid[i][j] = 0;
                else if ((grid[i][j] == 0) && (neighbours == 3)) nextGrid[i][j] = 1;
                else nextGrid[i][j] = grid[i][j];

            }
        }
        return nextGrid;
    }
    public static void update(){
        grid = changeGridState();
    }

    private static int countNeighbours(int[][] grid, int x, int y) {
        int sum = 0;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (grid[x + i][y + j] == alive) {
                    sum += 1;
                }
            }
        }
        return sum - 1;
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
