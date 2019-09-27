package v8.boardgames.action;

import org.junit.Test;
import static org.junit.Assert.*;
import v8.boardgames.game.Coord;
import v8.boardgames.game.GameState;
import v8.boardgames.game.fill.Fill;

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
        Coord coord1 = new Coord(0, 0);
        assertNull(state.getBoard().getContent(coord1));
        // simulate some steps
        // step 1: Black plays
        fill.updatePlay(state, new Play(coord1));
        assertEquals('B', state.getBoard().getContent(coord1).character());
        assertFalse(state.isEnd());
        // step 2: White plays
        Coord coord2 = new Coord(2, 0);
        fill.updatePlay(state, new Play(coord2));
        assertEquals('B', state.getBoard().getContent(coord1).character());
        assertEquals('W', state.getBoard().getContent(coord2).character());
        assertFalse(state.isEnd());
        // step 3.0 : Black saves the game
        (new Save()).perform(fill, state);
        // step 3: Black plays
        Coord coord3 = new Coord(0, 2);
        fill.updatePlay(state, new Play(coord3));
        assertEquals('B', state.getBoard().getContent(coord1).character());
        assertEquals('W', state.getBoard().getContent(coord2).character());
        assertEquals('B', state.getBoard().getContent(coord3).character());
        assertFalse(state.isEnd());
        // step 4: White plays
        Coord coord4 = new Coord(2, 1);
        fill.updatePlay(state, new Play(coord4));
        assertEquals('B', state.getBoard().getContent(coord1).character());
        assertEquals('W', state.getBoard().getContent(coord2).character());
        assertEquals('B', state.getBoard().getContent(coord3).character());
        assertEquals('W', state.getBoard().getContent(coord4).character());
        assertFalse(state.isEnd());
        // step 5: Black loads the game
        (new Load()).perform(fill, state);
        assertEquals('B', state.getBoard().getContent(coord1).character());
        assertEquals('W', state.getBoard().getContent(coord2).character());
        assertNull(state.getBoard().getContent(coord3));
        assertNull(state.getBoard().getContent(coord4));
        assertEquals(0, state.getCurrentPlayerIndex());
        assertFalse(state.isEnd());
        // step 6: Black plays, and looses
        fill.updatePlay(state, new Play(coord1));
        assertEquals('B', state.getBoard().getContent(coord1).character());
        assertEquals('W', state.getBoard().getContent(coord2).character());
        assertTrue(state.isEnd());
    }
}
