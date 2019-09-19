package v2.game.fill;

import org.junit.Test;
import static org.junit.Assert.*;

public class FillTest {
    
    /**
     * Test of update method, of class Fill.
     * Black looses as she plays on a cell she already occupies.
     */
    @Test
    public void testUpdate1() {
        Fill fill = new Fill();
        Board board = new Board();
        Action action = new Action();
        boolean black, end;
        // black plays (b,C)
        action.line = 1;
        action.column = 2;
        black = true;
        end = fill.update(board, action, black);
        assertFalse(end);
        // white plays (a,D)
        action.line = 0;
        action.column = 3;
        black = false;
        end = fill.update(board, action, black);
        assertFalse(end);
        // black plays (b,C)
        action.line = 1;
        action.column = 2;
        black = true;
        end = fill.update(board, action, black);
        assertTrue(end);
    }

    /**
     * Test of update method, of class Fill.
     * White looses as she plays on a cell that Black already occupies.
     */
    @Test
    public void testUpdate2() {
        Fill fill = new Fill();
        Board board = new Board();
        Action action = new Action();
        boolean black, end;
        // black plays (b,C)
        action.line = 1;
        action.column = 2;
        black = true;
        end = fill.update(board, action, black);
        assertFalse(end);
        // white plays (b,C)
        action.line = 1;
        action.column = 2;
        black = false;
        end = fill.update(board, action, black);
        assertTrue(end);
    }
}
