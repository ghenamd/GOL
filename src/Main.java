import logic.GameLogic;
import logic.GameUpdate;
import ui.Grid;
import ui.Gui;

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
