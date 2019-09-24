package v5.boardgames.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import v5.boardgames.game.Board;
import v5.boardgames.game.GameState;
import v5.boardgames.game.IGame;
import v5.boardgames.player.Player;

/**
 * Some tools related to files (save / load / etc).
 */
public class FileUtils {

    final static String SAVEFILE = "fill.dat";

    /**
     * Load a state of the game from a file.
     *
     * @param game the game currently played
     * @return the state of the game
     */
    public static GameState load(IGame game) {
        GameState state = null;
        Player[] players = game.players();
        try (BufferedReader br = new BufferedReader(new FileReader(SAVEFILE))) {
            String line = br.readLine();
            // process first line
            if (line.length() != 1) {
                System.out.println("Wrong file format: first line has more than one character. Abort.");
                return state;
            }
            char playerChar = line.charAt(0);
            Player player = Player.fromChar(playerChar, players);
            if (player == null) {
                System.out.println("Wrong file format: first line is not a color character. Abort.");
                return state;
            }
            // process subsequent lines
            final Board board = new Board();
            for (int lin = 0; lin < Board.NB_LIN; lin++) {
                line = br.readLine();
                if (line.length() != Board.NB_COL) {
                    System.out.println("Wrong file format: content lines lack columns. Abort.");
                    return state;
                }
                for (int col = 0; col < Board.NB_COL; col++) {
                    board.setContent(lin, col, line.charAt(col));
                }
            }
            // create game state
            int playerIndex = Player.indexFromChar(playerChar, players);
            state = new GameState(board, playerIndex, game);
        } catch (IOException e) {
            System.out.println("Something went wrong: " + e);
        }
        return state;
    }

    /**
     * Save the current state of the game to a file.
     *
     * @param state current state of the game
     */
    public static void save(GameState state) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(SAVEFILE))) {
            bw.write(state.getCurrentPlayer().displayChar());
            bw.write(System.lineSeparator());
            for (int line = 0; line < Board.NB_LIN; line++) {
                for (int col = 0; col < Board.NB_COL; col++) {
                    bw.write(state.getBoard().getContent(line, col));
                }
                bw.write(System.lineSeparator());
            }
        } catch (IOException e) {
            System.out.println("File write error : " + SAVEFILE);
        }
    }
}
