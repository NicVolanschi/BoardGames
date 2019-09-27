package v4.boardgames.game;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ActionTypeTest {
    
    @Test
    public void testNumberOfActions() {
        assertEquals(4, ActionType.values().length);
    }
}
