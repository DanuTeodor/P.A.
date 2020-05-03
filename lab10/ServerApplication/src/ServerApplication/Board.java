package ServerApplication;

public class Board {
    private int[][] board = new int[16][16];
    int dx[] = { 0, 1, 1, 1, 0, -1, -1, -1 };
    int dy[] = { 1, 1, 0, -1, -1, -1, 0, 1 };

    public Board(){
        for(int i = 0; i < 16; i++)
            for(int j = 0; j < 16; j++)
                board[i][j] = 0;
    }

    public boolean validMoves(int i, int j){
        if(board[i][j] == 0)
            return true;
        return false;
    }

    public void putMoves(int i, int j, int turn){
        board[i][j] = turn;
    }
    /*
    public boolean win(int turn){
        for(int i = 0; i < 16; i++)
            for(int j = 0; j < 16; j++);

    } */
}
