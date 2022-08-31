package cn.gl.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. 螺旋矩阵
 */
public class L54 {

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        List<Integer> integers = new L54().spiralOrder(matrix);
        System.out.println();
    }
    
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }

        int up = 0;
        int down = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (true) {
            for (int i = left; i <= right; i++) {
                result.add(matrix[up][i]);
            }
            up++;
            if (up > down) {
                break;
            }

            for (int i = up; i <= down; i++) {
                result.add(matrix[i][right]);
            }
            right--;
            if (right < left) {
                break;
            }

            for (int i = right; i>= left; i --) {
                result.add(matrix[down][i]);
            }
            down--;
            if (down < up) {
                break;
            }

            for (int i = down; i >= up; i--) {
                result.add(matrix[i][left]);
            }
            left ++;
            if (left > right) {
                break;
            }
        }
        return result;

    }
    
}
