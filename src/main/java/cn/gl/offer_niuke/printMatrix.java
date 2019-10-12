package cn.gl.offer_niuke;

import java.util.ArrayList;

public class printMatrix {

    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return list;
        int start = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        while (start * 2 < matrix.length && start * 2 < matrix[0].length) {
            int endX = cols - 1 - start;
            int endY  = rows - 1 - start;
            for (int i = start; i <= endX; i++) {
                list.add(matrix[start][i]);
            }
            if (start < endY){
                for (int i = start+1; i <= endY; i++) {
                    list.add(matrix[i][endX]);
                }
            }
            if (start < endY && start < endX) {
                for (int i = endX - 1; i >= start; i--) {
                    list.add(matrix[endY][i]);
                }
            }
            if (start < endX && endY - start > 1) {
                for (int i = endY - 1; i > start; i--) {
                    list.add(matrix[i][start]);
                }
            }
            start++;

        }
        return list;
    }
}
