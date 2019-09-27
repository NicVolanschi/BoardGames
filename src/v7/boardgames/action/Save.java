package v7.boardgames.action;

import v7.boardgames.game.GameState;
import v7.boardgames.game.IGame;
import v7.boardgames.io.FileUtils;

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
