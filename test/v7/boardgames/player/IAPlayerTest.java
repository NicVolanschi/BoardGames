package v7.boardgames.player;

import static org.junit.Assert.*;
import org.junit.Test;
import v7.boardgames.action.IAction;
import v7.boardgames.action.Play;
import v7.boardgames.game.Board;
import v7.boardgames.game.GameState;
import v7.boardgames.game.fill.Fill;

public class IAPlayerTest {
    
    /**
     * Test of play method, of class IAPlayer.
     */
    @Test
    public void testPlay() {
        Fill game = new Fill();
        GameState g = game.initialState();
        IAPlayer player = new IAPlayer("Black");
        IAction action = player.play(g);
        assertTrue(action instanceof Play);
        Play play = (Play)action;
        int line = play.getLine();
        int column = play.getColumn();
        assertTrue(0 <= line && line <= Board.NB_LIN);
        assertTrue(0 <= column && column <= Board.NB_COL);
    }
}
