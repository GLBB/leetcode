package cn.gl;

public class WordSearch_prev {

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
                    boolean res = helper2(board, word, i, j, 0);
                    if (res)
                        return true;
                }
            }
        }
        return false;
    }

    public static boolean helper2(char[][] board, String word, int x, int y, int idx) {
        if (0 <= x && x < board.length && 0 <= y && y < board[x].length) {
            if (board[x][y] == word.charAt(idx)) {
                board[x][y] = '$';
                if (idx == word.length() - 1) {
                    return true;
                }

                boolean res = helper2(board, word, x + 1, y, idx + 1)||
                        helper2(board, word, x - 1, y, idx + 1)||
                        helper2(board, word, x, y + 1, idx + 1)||
                        helper2(board, word, x, y - 1, idx + 1);
                board[x][y] = word.charAt(idx);
                return res;
            }
            return false;
        }
        return false;
    }
}
