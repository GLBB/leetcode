package cn.gl.newketiba;

/**
 * NC34 求路径
 */
public class NC34 {

    /**
     *
     * @param m int整型 
     * @param n int整型 
     * @return int整型
     */
    public int uniquePaths (int m, int n) {
        // write code here
        int[][] matrix = new int[m][n];
        for (int i=0; i < m; i++) {
            matrix[i][0] = 1;
        }
        for (int i=0; i < n; i++) {
            matrix[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1];

            }
        }
        return matrix[m - 1][n - 1];
    }
}
