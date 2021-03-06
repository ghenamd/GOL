package logic;

import ui.Grid;

public class GameUpdate extends Thread {
    private Grid grid;
    private GameLogic logic;

    public GameUpdate(Grid grid, GameLogic logic) {
        this.grid = grid;
        this.logic = logic;

    }

    @Override
    public void run() {
        while (true) {
            try {
                //Delay the thread for 1 sec
                sleep(100);
                logic.changeGridState();
                //We can call repaint from inside Grid paintComponent method
                //or GameUpdate thread
                grid.repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
