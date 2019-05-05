package cn.gl;

public class MinimumPathSum {

    public static void main(String[] args) {

    }

    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        int[][] res = new int[grid.length][];
        for (int i = 0; i < grid.length; i++) {
            res[i] = new int[grid[i].length];
        }
        res[0][0] = grid[0][0];
        for (int i = 1; i < grid[0].length; i++) {
            res[0][i] = res[0][i-1] + grid[0][i];
        }
        for (int i = 1; i < grid.length; i++) {
            res[i][0] = res[i-1][0] + grid[i][0];
        }
        for (int i = 1; i < res.length; i++) {
            for (int j = 1; j < res[i].length; j++) {
                int v1 = res[i-1][j] + grid[i][j];
                int v2 = res[i][j-1] + grid[i][j];
                res[i][j] = Math.min(v1, v2);
            }
        }
        int resIdx = res[res.length-1].length-1;
        return res[res.length-1][resIdx];
    }
}
