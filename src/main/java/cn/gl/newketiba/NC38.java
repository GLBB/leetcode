package cn.gl.newketiba;

import java.util.ArrayList;

/**
 * 螺旋矩阵
 */
public class NC38 {

    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        int x = 0;
        int y = 0;
        int maxX = matrix[0].length % 2 == 0 ? matrix[0].length / 2 : (matrix[0].length + 1) / 2;
        int maxY = matrix.length % 2 == 0? matrix.length / 2 : (matrix.length + 1) / 2;
        int width = matrix[0].length;
        int height = matrix.length;
        while (x < maxX && y < maxY) {
            // top left to top right
            for (int i = x; i < width - x; i++) {
                result.add(matrix[y][i]);
            }
            // top to down
            int rightX = width - 1 - x;
            for (int i = y + 1; i < height - y; i++) {
                result.add(matrix[i][rightX]);
            }
            // down right to down left
            int downY = height - 1 - y;
            if (downY > y) {
                for (int i = rightX - 1; i >= x; i--) {
                    result.add(matrix[downY][i]);
                }
            }

            // down left to top left
            if (rightX > x) {
                for (int i = downY - 1; i > y; i--) {
                    result.add(matrix[i][y]);
                }
            }

            x ++;
            y ++;
        }
        return result;

    }
}
