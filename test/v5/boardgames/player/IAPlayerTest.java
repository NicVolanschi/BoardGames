package v5.boardgames.player;

import static org.junit.Assert.*;
import org.junit.Test;
import v5.boardgames.game.Action;
import v5.boardgames.game.ActionType;
import v5.boardgames.game.Board;
import v5.boardgames.game.GameState;
import v5.boardgames.game.fill.Fill;

public class IAPlayerTest {
    
    /**
     * Test of play method, of class IAPlayer.
     */
    @Test
    public void testPlay() {
        Fill game = new Fill();
        GameState g = game.initialState();
        IAPlayer player = new IAPlayer("Black");
        Action action = player.play(g);
        assertEquals(ActionType.PLAY, action.getType());
        int line = action.getLine();
        int column = action.getColumn();
        assertTrue(0 <= line && line <= Board.NB_LIN);
        assertTrue(0 <= column && column <= Board.NB_COL);
    }
}
