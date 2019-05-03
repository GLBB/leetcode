package cn.gl;

public class SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return;
        int notIn = 0;
        for (int i = Integer.MIN_VALUE; i < Integer.MAX_VALUE; i++) {
            boolean flag = true;
            iter:
            for (int j = 0; j < matrix.length; j++) {
                for (int k = 0; k < matrix[j].length; k++) {
                    if (i == matrix[j][k]){
                        flag = false;
                        break iter;
                    }
                }
            }
            if (flag){
                notIn = i;
                break;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                helper(matrix, i, j, notIn);
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == notIn)
                    matrix[i][j] = 0;
            }
        }
    }

    public void helper(int[][] matrix, int x, int y, int notIn){
        if (matrix[x][y] == 0){
            matrix[x][y] = notIn;
            for (int i = 0; i < matrix[x].length; i++) {
                if (matrix[x][i] == 0){
                    helper(matrix, x, i, notIn);
                }else {
                    matrix[x][i] = notIn;
                }
            }
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][y] == 0){
                    helper(matrix, i, y, notIn);
                }else {
                    matrix[i][y] = notIn;
                }
            }
        }
    }

}
