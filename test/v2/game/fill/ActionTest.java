package v2.game.fill;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class ActionTest {

    /**
     * Test of fromKeyboard method, of class Action.
     */
    @Test
    public void testFromKeyboard() {
        Board board = new Board();
        {
            // input: valid line/column
            String input = "aD";
            Action action = new Action();
            action.fromKeyboard(input, board);
            assertEquals('a' - 'a', action.line);
            assertEquals('D' - 'A', action.column);
            assertFalse(action.quit);
        }
        {
            // input: wrong line/column
            String input = "aE";
            Action action = new Action();
            action.fromKeyboard(input, board);
            assertTrue(action.quit);
        }
        {
            // input: valid line but no column
            String input = "b";
            Action action = new Action();
            action.fromKeyboard(input, board);
            assertTrue(action.quit);
        }
        {
            // input: quit with 'q'
            String input = "q";
            Action action = new Action();
            action.fromKeyboard(input, board);
            assertTrue(action.quit);
        }
        {
            // input: quit with 'Q'
            String input = "Q";
            Action action = new Action();
            action.fromKeyboard(input, board);
            assertTrue(action.quit);
        }
    }

}
