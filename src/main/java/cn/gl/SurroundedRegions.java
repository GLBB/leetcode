package cn.gl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;

public class SurroundedRegions {

    public static void main(String[] args) {
        char[][] board = {
                {'O','X','X','O', 'X'},
                {'X','O','O','X', 'O'},
                {'X','O','X','O', 'X'},
                {'O','X','O','O', 'O'},
                {'X','X','O','X', 'O'},
        };
        solve(board);
        System.out.println();
    }

    public static void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0)
            return;
        HashSet<Point> set = new HashSet<>();
        int tableX = board.length;
        int tableY = board[0].length;
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O'){
                Point p = new Point(i, 0);
                dfs(board, p, set);
            }
            if (board[i][tableY-1] == 'O') {
                Point p = new Point(i, tableY-1);
                dfs(board, p, set);
            }
        }
        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i] == 'O') {
                Point p = new Point(0, i);
                dfs(board, p, set);
            }
            if (board[tableX-1][i] == 'O') {
                Point p = new Point(tableX-1, i);
                dfs(board, p, set);
            }
        }
        for (int i = 1; i < tableX-1; i++) {
            for (int j = 1; j < tableY-1; j++) {
                Point p = new Point(i, j);
                if (board[i][j] == 'O' && !set.contains(p)) {
                    board[i][j] = 'X';
                }
            }
        }

    }

    public static void dfs(char[][] board, Point p, HashSet<Point> list){
        if (list.contains(p))
            return;
        list.add(p);
        int tableX = board.length;
        int tableY = board[0].length;
        if (p.x+ 1< tableX) {
            Point point = new Point(p.x+1, p.y);
            if (!list.contains(point) && board[p.x+1][p.y] == 'O'){
//                list.add(point);
                dfs(board, point, list);
            }
        }
        if (p.x - 1 >= 0){
            Point point = new Point(p.x-1, p.y);
            if (!list.contains(point) && board[p.x-1][p.y] == 'O'){
//                list.add(point);
                dfs(board, point, list);
            }
        }

        if (p.y+1 <tableY){
            Point point = new Point(p.x, p.y+1);
            if (!list.contains(point) && board[p.x][p.y+1] == 'O'){
//                list.add(point);
                dfs(board, point, list);
            }
        }
        if (p.y-1 >=0){
            Point point = new Point(p.x, p.y-1);
            if (!list.contains(point) && board[p.x][p.y-1] == 'O'){
//                list.add(point);
                dfs(board, point, list);
            }
        }
    }

    static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x &&
                    y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

}
