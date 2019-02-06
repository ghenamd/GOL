package utils;

/**
 * It is possible to adjust the Ui (JFrame size) to ones needs
 * by changing the size of the WIDTH, HEIGHT and CELL_SIZE variables
 * If the user needs a bigger cell size, CELL_SIZE variable should be increased.
 * The number of rows and columns are calculated automatically depending
 * on WIDTH and HEIGHT variables
 */
public class Const {
    public static final String GAME_TITLE = "The Game Of Life";
    public static final int WIDTH = 600;
    public static final int HEIGHT = 600;
    public static final int CELL_SIZE = 10;
    public static int COLMS = WIDTH / CELL_SIZE;
    public static int ROWS = HEIGHT / CELL_SIZE;


}
