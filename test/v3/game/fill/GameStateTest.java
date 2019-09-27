package v3.game.fill;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class GameStateTest {
    
    /**
     * Test of updatePlay method, of class GameState.
     * Black looses as she plays on a cell she already occupies.
     */
    @Test
    public void testUpdate1() {
        Board board = new Board();
        GameState state = new GameState(board, true);
        Action action;
        // black plays (b,C)
        action = new Action(ActionType.PLAY, 1, 2);
        state.updatePlay(action);
        assertFalse(state.isEnd());
        // white plays (a,D)
        action = new Action(ActionType.PLAY, 0, 3);
        state.updatePlay(action);
        assertFalse(state.isEnd());
        // black plays (b,C)
        action = new Action(ActionType.PLAY, 1, 2);
        state.updatePlay(action);
        assertTrue(state.isEnd());
        assertEquals('W', state.getWinner());
    }

    /**
     * Test of update method, of class GameState.
     * White looses as she plays on a cell that Black already occupies.
     */
    @Test
    public void testUpdate2() {
        Board board = new Board();
        GameState state = new GameState(board, true);
        Action action;
        // black plays (b,C)
        action = new Action(ActionType.PLAY, 1, 2);
        state.updatePlay(action);
        assertFalse(state.isEnd());
        // white plays (b,C)
        action = new Action(ActionType.PLAY, 1, 2);
        state.updatePlay(action);
        assertTrue(state.isEnd());
        assertEquals('B', state.getWinner());
    }    
}
