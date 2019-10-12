package cn.gl.offer_niuke;

import java.util.ArrayList;
import java.util.List;

public class movingCount {

    public static void main(String[] args) {
        movingCount m = new movingCount();
        int count = m.movingCount(5, 10, 10);
        System.out.println(count);
    }

    public int movingCount(int threshold, int rows, int cols) {
        if (threshold <0 || rows <= 0 || cols <= 0)
            return 0;
        boolean[][] visit = new boolean[rows][cols];
        List<Integer> list = new ArrayList();
        list.add(0);
        helper(0, 0, rows, cols, threshold, visit, list);
        return list.get(0);
    }

    private void helper(int curRow, int curCol, int row, int col, int threshold,
                        boolean[][] visit, List<Integer> list){
        if (curRow < 0 || curCol < 0 || curRow >= row || curCol >= col || visit[curRow][curCol]){
            return;
        }
        int curSum = sum(curRow, curCol);
        if (curSum <= threshold) {
            visit[curRow][curCol] = true;
            list.set(0,list.get(0)+1);
            helper(curRow+1, curCol, row, col, threshold, visit, list);
            helper(curRow-1, curCol, row, col, threshold, visit, list);
            helper(curRow, curCol+1, row, col, threshold, visit, list);
            helper(curRow, curCol-1, row, col, threshold, visit, list);
        }
    }

    private int sum(int row, int col){
        int sum = 0;
        while (row!= 0) {
            int temp = row %10;
            sum+= temp;
            row /= 10;
        }
        while (col != 0) {
            int temp = col % 10;
            sum += temp;
            col /= 10;
        }
        return sum;
    }

}
