package cn.gl;

public class RotateImage {

    public void rotate(int[][] matrix) {
        int width = matrix.length;
        int temp = 0;
        for (int i = 0; i <width; i++) {
            for (int j = i; j < width; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        int semi = width/2;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < semi; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][width-j-1];
                matrix[i][width-j] = temp;
            }
        }

    }


}
