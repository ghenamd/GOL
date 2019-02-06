import logic.GameLogic;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GameOfLifeTest {
    private int[][] grid;
    private GameLogic logic;
    private int expectedVal ;
    @Before
    public void setup() {
        /*
         Visual grid to be tested
     idx : 0 1 2 3 4 5
        0|{1,0,0,1,0,1}
        1|{0,1,1,0,1,1}
        2|{1,1,0,0,1,0}
         */
        grid = new int[][]{{1,0,0,1,0,3},{0,1,1,0,1,1},{1,1,0,0,1,0}};
        expectedVal = 3;
        logic = new GameLogic();
    }

    /**
     *  Count cells from a certain position of the array(1,2)
     *   else  ArrayIndexOutOfBoundsException
     */
    @Test
    public void countCellsTest(){
       //Check grid above for indexes i and j.
        int n = logic.countCells(grid,1,2);
        Assert.assertEquals(expectedVal,n);
    }
}
