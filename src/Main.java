import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        Grid grid = new Grid();
       GameUpdate update= new GameUpdate(grid);
        JFrame frame = new JFrame();
        frame.setSize(600, 600);
        frame.setLocation(500, 25);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(grid);
        frame.setVisible(true);

    }
}
