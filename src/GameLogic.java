

public class GameLogic {

    private int alive = 1;
    private int dead = 0;
    private int[][] grid;
    private int[][] nextGrid;

    public GameLogic(int [][] grid) {
        this.grid = grid;
        nextGrid = new int[600][600];
    }


}
