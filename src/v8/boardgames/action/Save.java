package v8.boardgames.action;

import v8.boardgames.game.GameState;
import v8.boardgames.game.IGame;
import v8.boardgames.io.FileUtils;

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
