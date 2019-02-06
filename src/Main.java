import logic.GameLogic;
import logic.GameUpdate;
import ui.Grid;
import ui.Gui;

/**
 * It is possible to adjust the Ui (JFrame size) to ones needs
 * by changing the size of the WIDTH, HEIGHT and CELL_SIZE variables
 * in utils package-Const class.
 * If the user needs a bigger cell size, CELL_SIZE variable should be increased.
 * The number of rows and columns are calculated automatically depending
 * on WIDTH and HEIGHT variables
 * The Game can be stopped/closed by closing the Ui window
 */
public class Main {

    public static void main(String[] args) {

        GameLogic logic = new GameLogic();
        Grid grid = new Grid(logic);
        GameUpdate update = new GameUpdate(grid,logic);
        Gui ui = new Gui(grid);
        // Create game's Ui
        ui.createUi();
        //Start the thread to update the Ui
        update.start();
    }
}
