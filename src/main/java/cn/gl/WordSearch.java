package cn.gl;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Time Limit Exceeded
 */
public class WordSearch {
//[["A","B","C","E"],["S","F","E","S"],["A","D","E","E"]]
//        "ABCE SEEE FS"
    public static void main(String[] args) {
        char[][] border = {
                {'A','B','C','E'},
                {'S','F','E','S'},
                {'A','D','E','E'}
        };
        boolean rs = exist(border, "ABCESEEEFS");
        System.out.println(rs);
    }

    public static boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0)
            return false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)){
                    boolean[][] visit = new boolean[board.length][];
                    for (int k = 0; k < board.length; k++) {
                        visit[k] = new boolean[board[k].length];
                    }
                    boolean res = helper2(board, word, i, j, 0);
                    if (res)
                        return true;
                }
            }
        }
        return false;
    }

    public static boolean helper(char[][] board, String word, boolean[][] visit, int x, int y, int idx) {
        if (0 <= x && x < board.length && 0<= y && y < board[x].length) {
            if (board[x][y] == word.charAt(idx)) {
                if (visit[x][y] == false){
                    visit[x][y] = true;
                    if (idx == word.length() -1){
                        return true;
                    }
                    boolean b1 = helper(board, word, getVisit(visit), x+1, y, idx+1);
                    boolean b2 =helper(board, word, getVisit(visit), x-1, y, idx+1);
                    boolean b3 =helper(board, word, getVisit(visit), x, y+1, idx+1);
                    boolean b4 =helper(board, word, getVisit(visit), x, y-1, idx+1);
                    boolean res = b1 || b2 || b3 || b4;
                    return res;
                }else
                    return false;
            }
        }
        return false;
    }



    /**
     * Arrays.copy copy reference
     * @param visit
     * @return
     */
    public static boolean[][] getVisit(boolean[][] visit){
        boolean[][] temp = new boolean[visit.length][];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = Arrays.copyOf(visit[i], visit[i].length);
        }
        return temp;
    }

    public static boolean helper2(char[][] board, String word, int x, int y, int idx) {
        if (0 <= x && x < board.length && 0 <= y && y < board[x].length) {
            if (board[x][y] == word.charAt(idx)) {
                board[x][y] = '$';
                if (idx == word.length() - 1) {
                    return true;
                }
                boolean b1 = helper2(board, word, x + 1, y, idx + 1);
                boolean b2 = helper2(board, word, x - 1, y, idx + 1);
                boolean b3 = helper2(board, word, x, y + 1, idx + 1);
                boolean b4 = helper2(board, word, x, y - 1, idx + 1);
                boolean res = b1 || b2 || b3 || b4;
                board[x][y] = word.charAt(idx);
                return res;
            }
            return false;
        }
        return false;
    }

}
