package v6.boardgames.action;

import v6.boardgames.game.GameState;
import v6.boardgames.game.IGame;
import v6.boardgames.io.FileUtils;

/**
 * Action "Save".
 */
public class Save implements IAction {

    @Override
    public void perform(IGame game, GameState state) {
        FileUtils.save(state);
        System.out.println("## Game saved. ##");
    }
    
    @Override
    public String toString() {
        return "Save";
    }
}
