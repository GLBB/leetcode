package cn.gl.newketiba;

public class NC59 {

    public static void main(String[] args) {
        int[][] arr = {{1,3,5,9},{8,1,3,4},{5,0,6,1},{8,8,4,0}};
        int i = minPathSum(arr);
        System.out.println(i);
    }

    /**
     *
     * @param matrix int整型二维数组 the matrix
     * @return int整型
     */
    public static int minPathSum (int[][] matrix) {
        // write code here
        if (matrix == null || matrix.length == 0 || matrix[0].length  == 0) {
            return 0;
        }
        int[][] spendMatrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            if (i > 0) {
                spendMatrix[i][0] = spendMatrix[i - 1][0] + matrix[i][0];
            } else {
                spendMatrix[0][0] = matrix[0][0];
            }
        }
        for (int i = 0; i < matrix[0].length; i++) {
            if (i > 0) {
                spendMatrix[0][i] = spendMatrix[0][i - 1] + matrix[0][i];
            } else {
                spendMatrix[0][0] = matrix[0][0];
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                int choose = Math.min(spendMatrix[i][j - 1], spendMatrix[i - 1][j]);
                spendMatrix[i][j] = matrix[i][j] + choose;
            }
        }
        return spendMatrix[matrix.length - 1][matrix[0].length - 1];
    }
}
