package v7.boardgames.game.crush;

import org.junit.Test;
import static org.junit.Assert.*;
import v7.boardgames.action.Play;
import v7.boardgames.game.Board;
import v7.boardgames.game.GameState;

public class CrushTest {
    
    /**
     * Test of updatePlay method, of class Crush.
     * White looses as she plays on a cell she occupies.
     */
    @Test
    public void testUpdatePlay1() {
        // game
        final Crush crush = new Crush();
        // initial game state
        GameState state = crush.initialState();
        Board board = state.getBoard();
        // check it
        assertNull(board.getContent(0, 0));
        // simulate some steps
        // step 1: Black plays
        crush.updatePlay(state, new Play(0, 0));
        assertEquals('B', board.getContent(0, 0).character());
        assertFalse(state.isEnd());
        // step 2: White plays
        crush.updatePlay(state, new Play(2, 0));
        assertEquals('B', board.getContent(0, 0).character());
        assertEquals('W', board.getContent(2, 0).character());
        assertFalse(state.isEnd());
        // step 3: Black plays
        crush.updatePlay(state, new Play(0, 2));
        assertEquals('B', board.getContent(0, 0).character());
        assertEquals('W', board.getContent(2, 0).character());
        assertEquals('B', board.getContent(0, 2).character());
        assertFalse(state.isEnd());
        // step 4: White plays
        crush.updatePlay(state, new Play(2, 0));
        assertEquals('B', board.getContent(0, 0).character());
        assertEquals('W', board.getContent(2, 0).character());
        assertEquals('B', board.getContent(0, 2).character());
        assertTrue(state.isEnd());
        assertEquals('B', state.getWinner().displayChar());
    }
    
    /**
     * Test of updatePlay method, of class Crush.
     * Black wins as she plays on a cell that White occupies.
     */
    @Test
    public void testUpdatePlay2() {
        // game
        final Crush crush = new Crush();
        // initial game state
        GameState state = crush.initialState();
        Board board = state.getBoard();
        boolean end;
        // check it
        assertNull(board.getContent(0, 0));
        // simulate some steps
        // step 1: Black plays
        crush.updatePlay(state, new Play(0, 0));
        assertEquals('B', board.getContent(0, 0).character());
        assertFalse(state.isEnd());
        // step 2: White plays
        crush.updatePlay(state, new Play(2, 0));
        assertEquals('B', board.getContent(0, 0).character());
        assertEquals('W', board.getContent(2, 0).character());
        assertFalse(state.isEnd());
        // step 3: Black plays
        crush.updatePlay(state, new Play(0, 2));
        assertEquals('B', board.getContent(0, 0).character());
        assertEquals('W', board.getContent(2, 0).character());
        assertEquals('B', board.getContent(0, 2).character());
        assertFalse(state.isEnd());
        // step 4: White plays
        crush.updatePlay(state, new Play(1, 0));
        assertEquals('B', board.getContent(0, 0).character());
        assertEquals('W', board.getContent(2, 0).character());
        assertEquals('B', board.getContent(0, 2).character());
        assertEquals('W', board.getContent(1, 0).character());
        assertFalse(state.isEnd());
        // step 5: Black plays
        crush.updatePlay(state, new Play(2, 0));
        assertEquals('B', board.getContent(0, 0).character());
        assertEquals('W', board.getContent(2, 0).character());
        assertEquals('B', board.getContent(0, 2).character());
        assertEquals('W', board.getContent(1, 0).character());
        assertTrue(state.isEnd());
        assertEquals('B', state.getWinner().displayChar());
    }    
}
