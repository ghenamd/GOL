package logic;

import java.util.Random;

public class GameLogic {

    private  int colms = 60;
    private  int rows = 60;
    private int alive = 1;
    private int dead = 0;
    private  int[][] grid;

    public GameLogic() {
        grid = new int[colms][rows];
        init();
    }
    public  void changeGridState() {
        //Create next sate of the grid to be swapped with the initial one
        int[][] nextGrid = new int[rows][colms];
        for (int i = 1; i < rows - 1; i++) {
            for (int j = 1; j < colms - 1; j++) {
                int neighbours = countCells(grid, i, j);
                //Apply the Game Of Life rules
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

    //Method to provide int[][] grid 2D array for the Grid class to be painted
    public int[][] getGrid() {
        return grid;
    }

    //Initialize the int[][] grid 2D array at the beginning of the game
    private     void init() {
        Random random = new Random();
        for (int i =0;i < colms;i++) {
            for (int j =0;j < rows;j++) {
                grid[i][j] = random.nextInt(2);
            }
        }
    }
    //Method to count neighbours
    private  int countNeighbours(int[][] grid, int x, int y) {
        int sum = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                sum += grid[x+i][y+j];
            }
        }
        sum -= grid[x][y];
        return sum;
    }

    //Method to count neighbours
    private  int countCells(int[][] grid, int i, int j) {
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
