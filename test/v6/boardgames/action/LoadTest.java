package v6.boardgames.action;

import org.junit.Test;
import static org.junit.Assert.*;
import v6.boardgames.game.Board;
import v6.boardgames.game.GameState;
import v6.boardgames.game.fill.Fill;

public class LoadTest {
    
    /**
     * Test of perform method, of class Load.
     */
    @Test
    public void testPerform() {
        // game
        final Fill fill = new Fill();
        // initial game state
        GameState state = fill.initialState();
        // check it
        assertEquals(' ', state.getBoard().getContent(0, 0));
        // simulate some steps
        // step 1: Black plays
        fill.updatePlay(state, new Play(0, 0));
        assertEquals('B', state.getBoard().getContent(0, 0));
        assertFalse(state.isEnd());
        // step 2: White plays
        fill.updatePlay(state, new Play(2, 0));
        assertEquals('B', state.getBoard().getContent(0, 0));
        assertEquals('W', state.getBoard().getContent(2, 0));
        assertFalse(state.isEnd());
        // step 3.0 : Black saves the game
        (new Save()).perform(fill, state);
        // step 3: Black plays
        fill.updatePlay(state, new Play(0, 2));
        assertEquals('B', state.getBoard().getContent(0, 0));
        assertEquals('W', state.getBoard().getContent(2, 0));
        assertEquals('B', state.getBoard().getContent(0, 2));
        assertFalse(state.isEnd());
        // step 4: White plays
        fill.updatePlay(state, new Play(2, 1));
        assertEquals('B', state.getBoard().getContent(0, 0));
        assertEquals('W', state.getBoard().getContent(2, 0));
        assertEquals('B', state.getBoard().getContent(0, 2));
        assertEquals('W', state.getBoard().getContent(2, 1));
        assertFalse(state.isEnd());
        // step 5: Black loads the game
        (new Load()).perform(fill, state);
        assertEquals('B', state.getBoard().getContent(0, 0));
        assertEquals('W', state.getBoard().getContent(2, 0));
        assertEquals(Board.EMPTY_CELL, state.getBoard().getContent(0, 2));
        assertEquals(Board.EMPTY_CELL, state.getBoard().getContent(2, 1));
        assertEquals(0, state.getCurrentPlayerIndex());
        assertFalse(state.isEnd());
        // step 6: Black plays, and looses
        fill.updatePlay(state, new Play(0, 0));
        assertEquals('B', state.getBoard().getContent(0, 0));
        assertEquals('W', state.getBoard().getContent(2, 0));
        assertTrue(state.isEnd());
    }
}
