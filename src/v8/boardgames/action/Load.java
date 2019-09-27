package v8.boardgames.action;

import v8.boardgames.game.GameState;
import v8.boardgames.game.IGame;
import v8.boardgames.io.FileUtils;

/**
 * Action "Load".
 */
public class Load implements IAction {

    @Override
    public void perform(IGame game, GameState state) {
        FileUtils.load(game, state);
        System.out.println("## Previous game loaded. ##");
    }
    
    @Override
    public String toString() {
        return "Load";
    }
}
