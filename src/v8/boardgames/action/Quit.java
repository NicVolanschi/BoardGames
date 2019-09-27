package v8.boardgames.action;

import v8.boardgames.game.GameState;
import v8.boardgames.game.IGame;

/**
 * Action "Quit".
 */
public class Quit implements IAction {

    @Override
    public void perform(IGame game, GameState state) {
        state.setEnd(true);
        System.out.println("## Bye. ##");
    }
    
    @Override
    public String toString() {
        return "Quit";
    }
}
