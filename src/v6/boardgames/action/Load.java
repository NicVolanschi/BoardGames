package v6.boardgames.action;

import v6.boardgames.game.GameState;
import v6.boardgames.game.IGame;
import v6.boardgames.io.FileUtils;

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
