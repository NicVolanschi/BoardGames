package v5.boardgames.player;

import org.junit.Test;
import static org.junit.Assert.*;
import v5.boardgames.game.Action;
import v5.boardgames.game.GameState;

public class PlayerTest {

    /**
     * A minimal implementation.
     */
    class TestPlayer extends Player {
        
        /**
         * Constructor
         * @param aName name of the player
         */
        public TestPlayer(String aName) {
            super(aName);
        }
        
        @Override
        public Action play(GameState g) {
            return Action.actionQuit();
        }
    }
    
    /**
     * Test of getName method, of class Player.
     */
    @Test
    public void testGetName() {
        final Player player = new TestPlayer("Daniela");
        assertEquals("Daniela", player.getName());
    }

    /**
     * Test of displayChar method, of class Player.
     */
    @Test
    public void testDisplayChar() {
        final Player player = new TestPlayer("Daniela");
        assertEquals('D', player.displayChar());
    }

    /**
     * Test of fromChar method, of class Player.
     */
    @Test
    public void testFromChar() {
        Player adam = new TestPlayer("Adam");
        Player eve = new TestPlayer("Eve");
        Player[] players = {adam, eve};
        assertEquals(eve, Player.fromChar('E', players));
        assertEquals(adam, Player.fromChar('A', players));
    }

    /**
     * Test of indexFromChar method, of class Player.
     */
    @Test
    public void testIndexFromChar() {
        Player adam = new TestPlayer("Adam");
        Player eve = new TestPlayer("Eve");
        Player[] players = {adam, eve};
        assertEquals(1, Player.indexFromChar('E', players));
        assertEquals(0, Player.indexFromChar('A', players));
    }
}
