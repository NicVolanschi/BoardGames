package v5.boardgames;

import java.util.Scanner;
import v5.boardgames.game.Action;
import v5.boardgames.game.GameState;
import v5.boardgames.game.IGame;
import v5.boardgames.game.crush.Crush;
import v5.boardgames.game.fill.Fill;
import v5.boardgames.io.FileUtils;
import v5.boardgames.player.Player;

/**
 * Menu to choose a game.
 */
public class BoardGames {

    /**
     * Menu, where the player chooses a game.
     */
    private void menu() {
        final Scanner s = new Scanner(System.in);
        boolean end = false;
        IGame game = null;
        while (!end) {
            System.out.println("-------------------------------");
            System.out.println("Choose a game (or 'q' to quit):");
            System.out.println("1. Fill");
            System.out.println("2. Crush");
            System.out.print("> ");
            String input = s.next();
            if (input == null || input.length() < 1) {
                end = true;
            } else {
                char c = input.charAt(0);
                switch (c) {
                    case 'q':
                    case 'Q':
                        end = true;
                        break;
                    case '1':
                        game = new Fill();
                        break;
                    case '2':
                        game = new Crush();
                        break;
                    default:
                        break;
                }
            }
            if (!end && game != null) {
                start(game);
            }
        }
    }

    /**
     * Start a game.
     *
     * @param game the chosen game
     */
    private void start(IGame game) {
        GameState state = game.initialState();
        while (!state.isEnd()) {
            System.out.println(state.getBoard().display(false));
            Player current = state.getCurrentPlayer();
            final Action action = current.play(state);
            switch (action.getType()) {
                case QUIT:
                    state.setEnd(true);
                    System.out.println("## Bye. ##");
                    break;
                case PLAY:
                    game.updatePlay(state, action);
                    System.out.println(current + " plays: " + action);
                    System.out.println("## Board updated. ##");
                    break;
                case LOAD:
                    state = FileUtils.load(game);
                    System.out.println("## Previous game loaded. ##");
                    break;
                case SAVE:
                    FileUtils.save(state);
                    System.out.println("## Game saved. ##");
                    break;
                default:
                    System.out.println("Not implemented : " + action.getType());
                    break;
            }
        }
    }

    /**
     * Main method
     *
     * @param args unused command-line arguments
     */
    public static void main(String[] args) {
        BoardGames bg = new BoardGames();
        bg.menu();
    }
}
