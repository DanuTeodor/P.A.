package Lab7;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Game {
    private Board board ;
    private List<Player> players;
    private List<Thread> threads;

    public Game (int NumberOfPlayers, int NumberOfTokens, int limit, int GameFinish){
        board = new Board(NumberOfTokens);
        players = new ArrayList<>();

        for (int i = 0; i < NumberOfPlayers; i++) {
            players.add(new Player("Player" + i, board, GameFinish));
        }
        threads = new ArrayList<>();
    }

    public void Start() {
        for (Player player : players) {
            threads.add(new Thread(player));
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException exception) {
                System.err.println(exception);
            }
        }
    }


    public void ShowResults() {
        if (!board.getWinner()) {
            for (Player player : players) {
                player.setPoints();
            }
        }

        players.sort(Comparator.comparing(Player::getPoints).reversed());

        System.out.println("\n[FINAL RESULTS]");

        for (Player player : players) {
            System.out.print("\"" + player.getName() + "\"" + " scored " + player.getPoints()
                    + " with the following tokens: [ ");

            for (Token token : player.getTokens()) {
                System.out.print(token.getValue() + " ");
            }

            System.out.println("]");
        }
    }
}
