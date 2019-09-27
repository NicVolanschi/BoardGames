package v8.boardgames.action;

// similar to FillTest

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import v8.boardgames.game.Coord;
import v8.boardgames.game.GameState;
import v8.boardgames.game.fill.Fill;

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
        Coord coord1 = new Coord(0, 0);
        assertNull(state.getBoard().getContent(coord1));
        // simulate one step
        (new Play(coord1)).perform(fill, state);
        assertEquals('B', state.getBoard().getContent(coord1).character());
        assertFalse(state.isEnd());
    }
}
