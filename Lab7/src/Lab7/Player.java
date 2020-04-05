package Lab7;

import java.util.Scanner;
import java.util.Vector;

public class Player implements Runnable {
    private String name;
    private Board board;
    private int GameFinish;
    private int points;
    private Vector<Token> tokens;


    public Player(String name, Board board, int GameFinish) {
        this.name = name;
        this.board = board;
        this.GameFinish = GameFinish;
    }

    public void ReadToken(int token){
        Scanner keyboard = new Scanner(System.in);
        int tk = keyboard.nextInt();
    }

    public String getName() {
        return name;
    }

    public int getPoints(){
        return points;
    }

    public Vector<Token> getTokens() {
        return tokens;
    }

    public void setPoints(){}


    public void setName(String name, Board board, int GameFinish) {
        this.name = name;
    }


    @Override
    public synchronized void run(){

    }

}
