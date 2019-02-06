package logic;

import ui.Grid;

public class GameUpdate extends Thread {
    private Grid grid;
    private GameLogic logic;

    public GameUpdate(Grid grid,GameLogic logic) {
        this.grid = grid;
        this.logic = logic;

    }
    @Override
    public void run() {
        while(true) {
            try {
                sleep(100);
                logic.changeGridState();
                grid.repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
