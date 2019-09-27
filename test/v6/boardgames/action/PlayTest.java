package v6.boardgames.action;

// similar to FillTest

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.junit.Test;
import v6.boardgames.game.GameState;
import v6.boardgames.game.fill.Fill;

public class PlayTest {
    
    /**
     * Test of updatePlay method, of class Fill.
     * White looses as she plays on a cell she occupies.
     */
    @Test
    public void testPerform() {
        // game
        final Fill fill = new Fill();
        // initial game state
        GameState state = fill.initialState();
        // check it
        assertEquals(' ', state.getBoard().getContent(0, 0));
        // simulate one step
        (new Play(0, 0)).perform(fill, state);
        assertEquals('B', state.getBoard().getContent(0, 0));
        assertFalse(state.isEnd());
    }
}
