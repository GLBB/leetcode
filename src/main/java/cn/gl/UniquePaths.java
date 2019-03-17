package cn.gl;

public class UniquePaths {

    public static void main(String[] args) {
        UniquePaths solution = new UniquePaths();
        int i = solution.uniquePaths(7, 3);
        System.out.println(i);
    }

    public int uniquePaths(int m, int n) {
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            matrix[i][0] = 1;
        }
        for (int i = 1; i < n; i++) {
            matrix[0][i] = 1;
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                matrix[i][j] = matrix[i-1][j] + matrix[i][j-1];
            }
        }
        return matrix[m-1][n-1];


    }
}
