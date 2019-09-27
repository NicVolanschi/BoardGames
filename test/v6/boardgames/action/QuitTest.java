package v6.boardgames.action;

import org.junit.Test;
import static org.junit.Assert.*;
import v6.boardgames.game.GameState;
import v6.boardgames.game.IGame;
import v6.boardgames.game.fill.Fill;

public class QuitTest {
    
    /**
     * Test of perform method, of class Quit.
     */
    @Test
    public void testPerform() {
        IGame game = new Fill();
        GameState state = game.initialState();
        (new Quit()).perform(game, state);
        assertTrue(state.isEnd());
    }
    
}
