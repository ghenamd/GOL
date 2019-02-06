package logic;
import java.util.Random;
import static utils.Const.COLMS;
import static utils.Const.ROWS;

public class GameLogic {

    private int alive = 1;
    private int dead = 0;
    private  int[][] currentGrid;
    public GameLogic() {
        currentGrid = new int[COLMS][ROWS];
        init();
    }
    //Method to change the state of the currentGrid from the current currentGrid to next currentGrid
    public  void changeGridState() {
        //Create the next grid to be swapped with the current one
        int[][] nextGrid = new int[COLMS][ROWS];
        //In this example we do not take the edges into account
        for (int i = 1; i < COLMS - 1; i++) {
            for (int j = 1; j < ROWS - 1; j++) {
                int neighbours = countCells(currentGrid, i, j);
                //Apply the Game Of Life rules
                //When a live cell has fewer than two neighbours or more than three
                //	then this cell dies
                if (currentGrid[i][j] == alive && (neighbours < 2 || neighbours > 3)) {
                    nextGrid[i][j] = dead;
                }
                //When a live cell has two or three neighbours
                //	then this cell stays alive
                if (currentGrid[i][j] == alive && (neighbours == 3 || neighbours == 2)) {
                    nextGrid[i][j] = alive;
                }
                //When an empty position has exactly three neighbouring cells
                //	then a cell is created in this position
                if (currentGrid[i][j] == dead && neighbours == 3) {
                    nextGrid[i][j] = alive;
                }
            }
        }
        currentGrid = nextGrid;
    }

    //Method to provide int[][] currentGrid 2D array for the Grid class to draw the cell grid
    public int[][] getCurrentGrid() {
        return currentGrid;
    }

    //Initialize the int[][] currentGrid 2D array at the beginning of the game
    private void init() {
        Random random = new Random();
        for (int i = 0; i < COLMS; i++) {
            for (int j = 0; j < ROWS; j++) {
                currentGrid[i][j] = random.nextInt(2);
            }
        }
    }
    /**
     *  Method to count neighbours
     *   @param x: array index
     * @param y: array index
     */
    private  int countNeighbours(int[][] grid, int x, int y) {
        int sum = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                sum =sum + grid[x+i][y+j];
            }
        }
        sum = sum- grid[x][y];
        return sum;
    }

    /**
     *  Method to count neighbours
     *   @param i: array index
     * @param j: array index
     */
    public  int countCells(int[][] grid, int i, int j) {
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
