package v5.boardgames.game.crush;

import org.junit.Test;
import static org.junit.Assert.*;
import v5.boardgames.game.Action;
import v5.boardgames.game.ActionType;
import v5.boardgames.game.Board;
import v5.boardgames.game.GameState;

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
        assertEquals(' ', board.getContent(0, 0));
        // simulate some steps
        // step 1: Black plays
        crush.updatePlay(state, new Action(ActionType.PLAY, 0, 0));
        assertEquals('B', board.getContent(0, 0));
        assertFalse(state.isEnd());
        // step 2: White plays
        crush.updatePlay(state, new Action(ActionType.PLAY, 2, 0));
        assertEquals('B', board.getContent(0, 0));
        assertEquals('W', board.getContent(2, 0));
        assertFalse(state.isEnd());
        // step 3: Black plays
        crush.updatePlay(state, new Action(ActionType.PLAY, 0, 2));
        assertEquals('B', board.getContent(0, 0));
        assertEquals('W', board.getContent(2, 0));
        assertEquals('B', board.getContent(0, 2));
        assertFalse(state.isEnd());
        // step 4: White plays
        crush.updatePlay(state, new Action(ActionType.PLAY, 2, 0));
        assertEquals('B', board.getContent(0, 0));
        assertEquals('W', board.getContent(2, 0));
        assertEquals('B', board.getContent(0, 2));
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
        // check it
        assertEquals(' ', board.getContent(0, 0));
        // simulate some steps
        // step 1: Black plays
        crush.updatePlay(state, new Action(ActionType.PLAY, 0, 0));
        assertEquals('B', board.getContent(0, 0));
        assertFalse(state.isEnd());
        // step 2: White plays
        crush.updatePlay(state, new Action(ActionType.PLAY, 2, 0));
        assertEquals('B', board.getContent(0, 0));
        assertEquals('W', board.getContent(2, 0));
        assertFalse(state.isEnd());
        // step 3: Black plays
        crush.updatePlay(state, new Action(ActionType.PLAY, 0, 2));
        assertEquals('B', board.getContent(0, 0));
        assertEquals('W', board.getContent(2, 0));
        assertEquals('B', board.getContent(0, 2));
        assertFalse(state.isEnd());
        // step 4: White plays
        crush.updatePlay(state, new Action(ActionType.PLAY, 1, 0));
        assertEquals('B', board.getContent(0, 0));
        assertEquals('W', board.getContent(2, 0));
        assertEquals('B', board.getContent(0, 2));
        assertEquals('W', board.getContent(1, 0));
        assertFalse(state.isEnd());
        // step 5: Black plays
        crush.updatePlay(state, new Action(ActionType.PLAY, 2, 0));
        assertEquals('B', board.getContent(0, 0));
        assertEquals('W', board.getContent(2, 0));
        assertEquals('B', board.getContent(0, 2));
        assertEquals('W', board.getContent(1, 0));
        assertTrue(state.isEnd());
        assertEquals('B', state.getWinner().displayChar());
    }    
}
