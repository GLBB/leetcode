package cn.gl;

import java.util.HashSet;

public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                boolean sus = isRowValid(board, i, j)&&
                                isColValid(board, i, j)
                                && isGridValid(board, i, j);
                if (!sus)
                    return false;
            }
        }

        return true;
    }

    public boolean isRowValid(char[][] board, int x, int y){
        char[] row = board[x];
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < row.length; i++) {
            if (row[i]>='0' && row[i] <= '9'){
                boolean success = set.add(row[i]);
                if (!success)
                    return false;
            }
        }
        return true;
    }

    public boolean isColValid(char[][] board, int x, int y) {
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            if (board[i][y] >= '0' && board[i][y] <= '9'){
                boolean success = set.add(board[i][y]);
                if (!success)
                    return false;
            }
        }
        return true;
    }

    public boolean isGridValid(char[][] board, int x, int y) {
        HashSet<Character> set = new HashSet<>();
        int startX = (x/3)*3, startY = (y/3)*3;
        for (int i = startX; i < startX+3; i++) {
            for (int j = startY; j < startY+3; j++) {
                if (board[i][j] >= '0' && board[i][j] <= '9'){
                    boolean success = set.add(board[i][j]);
                    if (!success)
                        return false;
                }
            }
        }
        return true;
    }
}
