package v6.boardgames;

import java.util.Scanner;
import v6.boardgames.game.GameState;
import v6.boardgames.game.IGame;
import v6.boardgames.game.crush.Crush;
import v6.boardgames.game.crush3.Crush3;
import v6.boardgames.game.fill.Fill;
import v6.boardgames.player.Player;
import v6.boardgames.action.IAction;

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
            System.out.println("3. Crush3");
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
                    case '3':
                        game = new Crush3();
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
            final IAction action = current.play(state);
            System.out.println(current + " plays: " + action);
            action.perform(game, state);
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
