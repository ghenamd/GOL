import java.util.*;

public class GameUpdate  {
   private Timer timer;
   private Grid grid;

    public GameUpdate( Grid grid) {
        this.timer = new Timer();
        this.grid = grid;
        this.update();
    }

    public void  update(){
        timer.schedule(new TimerTask() {
            @Override
            public void run() {

                Grid.changeGridState();
                grid.repaint();

            }
        },0,250);
}
}
