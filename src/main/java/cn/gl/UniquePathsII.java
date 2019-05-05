package cn.gl;

public class UniquePathsII {


    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0)
            return 0;
        int[][] res = new int[obstacleGrid.length][];
        for (int i = 0; i < obstacleGrid.length; i++) {
            res[i] = new int[obstacleGrid[i].length];
        }
        boolean flag = false;
        for (int i = 0; i < res[0].length; i++) {
            if (obstacleGrid[0][i] == 1){
                flag = true;
            }
            if (flag){
                res[0][i] = 0;
            }else {
                res[0][i] = 1;
            }
        }
        flag = false;
        for (int i = 0; i < res.length; i++) {
            if (obstacleGrid[i][0] == 1){
                flag = true;
            }
            if (flag){
                res[i][0] = 0;
            }else
                res[i][0] = 1;
        }
        for (int i = 1; i < res.length; i++) {
            for (int j = 1; j < res[i].length; j++) {
                if (obstacleGrid[i][j] == 1){
                    res[i][j] = 0;
                }else {
                    res[i][j] = res[i-1][j] + res[i][j-1];
                }
            }
        }
        int lastRightIdx = res[res.length-1].length-1;
        return res[res.length-1][lastRightIdx];
    }

}
