package v8.boardgames.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import v8.boardgames.game.Board;
import v8.boardgames.game.Coord;
import v8.boardgames.game.GameState;
import v8.boardgames.game.IGame;
import v8.boardgames.game.Piece;
import v8.boardgames.player.Player;

/**
 * Some tools related to files (save / load / etc).
 */
public class FileUtils {

    final static String SAVEFILE = "fill.dat";

    /**
     * Load a state of the game from a file.
     *
     * @param game the game currently played
     * @param state the state of the game, to be updated
     */
    public static void load(IGame game, final GameState state) {
        Player[] players = game.players();
        // initialize the set of pieces of each player
        // (then, we'll remove those that are on the board)
        Map<Player, Set<Piece>> pieces = new HashMap<>();
        for (Player player : players) {
            pieces.put(player, game.initPieces(player));
        }
        // now, process file
        try (BufferedReader br = new BufferedReader(new FileReader(SAVEFILE))) {
            String line = br.readLine();
            // process first line
            if (line.length() != 1) {
                System.out.println("Wrong file format: first line has more than one character. Abort.");
                return;
            }
            char playerChar = line.charAt(0);
            Player player = Player.fromChar(playerChar, players);
            if (player == null) {
                System.out.println("Wrong file format: first line is not a color character. Abort.");
                return;
            }
            // process subsequent lines
            final Board board = new Board();
            for (int lin = 0; lin < Board.NB_LIN; lin++) {
                line = br.readLine();
                if (line.length() != Board.NB_COL) {
                    System.out.println("Wrong file format: content lines lack columns. Abort.");
                    return;
                }
                for (int col = 0; col < Board.NB_COL; col++) {
                    char charPiece = line.charAt(col);
                    Piece piece = game.deserializePiece(charPiece, pieces);
                    if (piece != null) {
                        board.setContent(new Coord(lin, col), piece);
                        pieces.get(player).remove(piece);
                    }
                }
            }
            // create game state
            int playerIndex = Player.indexFromChar(playerChar, players);
            state.setCurrentPlayer(playerIndex);
            state.setBoard(board);
        } catch (IOException e) {
            System.out.println("Something went wrong: " + e);
        }
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
                    char toSave = Board.EMPTY_CELL;
                    Coord coord = new Coord(line, col);
                    Piece piece = state.getBoard().getContent(coord);
                    if (piece != null) {
                        toSave = piece.character();
                    }
                    bw.write(toSave);
                }
                bw.write(System.lineSeparator());
            }
        } catch (IOException e) {
            System.out.println("File write error : " + SAVEFILE);
        }
    }
}
