package Lab7;

import java.util.*;

public class Board {
    private int SizeOfBoard;
    List<Token> Tokens;
    private boolean Winner;

    public Board(int size) {
        this.SizeOfBoard = size;
        this.Tokens = new ArrayList<>(size);
    }

    public int getSizeOfBoard() {
        return SizeOfBoard;
    }

    public void setSizeOfBoard(int size) {
        this.SizeOfBoard = size;
    }

    public void addTokens(int limit) {
        Set<Integer> distinctValues = new HashSet<>();

        while (distinctValues.size() < SizeOfBoard) {
            distinctValues.add((int) (Math.random() * limit +1));
        }

        for (Integer integer : distinctValues) {
            Tokens.add(new Token(integer));
        }

        Tokens = Collections.synchronizedList(Tokens);
    }


    public int getSize() {
        return SizeOfBoard  ;
    }

    public boolean getWinner() {
        return Winner;
    }

}




