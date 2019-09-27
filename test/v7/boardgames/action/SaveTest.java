package v7.boardgames.action;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import v7.boardgames.game.GameState;
import v7.boardgames.game.fill.Fill;

// Similar to LoadTest: both use Load and Save
public class SaveTest {
    
    /**
     * Test of perform method, of class Save.
     */
    @Test
    public void testPerform() {
        // game
        final Fill fill = new Fill();
        // initial game state
        GameState state = fill.initialState();
        // check it
        assertNull(state.getBoard().getContent(0, 0));
        // simulate some steps
        // step 1: Black plays
        fill.updatePlay(state, new Play(0, 0));
        assertEquals('B', state.getBoard().getContent(0, 0).character());
        assertFalse(state.isEnd());
        // step 2: White plays
        fill.updatePlay(state, new Play(2, 0));
        assertEquals('B', state.getBoard().getContent(0, 0).character());
        assertEquals('W', state.getBoard().getContent(2, 0).character());
        assertFalse(state.isEnd());
        // step 3.0 : Black saves the game
        (new Save()).perform(fill, state);
        // step 3: Black plays
        fill.updatePlay(state, new Play(0, 2));
        assertEquals('B', state.getBoard().getContent(0, 0).character());
        assertEquals('W', state.getBoard().getContent(2, 0).character());
        assertEquals('B', state.getBoard().getContent(0, 2).character());
        assertFalse(state.isEnd());
        // step 4: White plays
        fill.updatePlay(state, new Play(2, 1));
        assertEquals('B', state.getBoard().getContent(0, 0).character());
        assertEquals('W', state.getBoard().getContent(2, 0).character());
        assertEquals('B', state.getBoard().getContent(0, 2).character());
        assertEquals('W', state.getBoard().getContent(2, 1).character());
        assertFalse(state.isEnd());
        // step 5: Black loads the game
        (new Load()).perform(fill, state);
        assertEquals('B', state.getBoard().getContent(0, 0).character());
        assertEquals('W', state.getBoard().getContent(2, 0).character());
        assertNull(state.getBoard().getContent(0, 2));
        assertNull(state.getBoard().getContent(2, 1));
        assertEquals(0, state.getCurrentPlayerIndex());
        assertFalse(state.isEnd());
        // step 6: Black plays, and looses
        fill.updatePlay(state, new Play(0, 0));
        assertEquals('B', state.getBoard().getContent(0, 0).character());
        assertEquals('W', state.getBoard().getContent(2, 0).character());
        assertTrue(state.isEnd());
    }
}
