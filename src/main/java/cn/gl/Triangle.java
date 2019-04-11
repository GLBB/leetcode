package cn.gl;

import java.util.LinkedList;
import java.util.List;

public class Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        //if row ==  0
        if (triangle.size() == 0)
            return 0;
        int[][] res = new int[triangle.size()][];
        int row = triangle.size();
        int endLength = triangle.get(triangle.size()-1).size();
        res[triangle.size() - 1] = new int[endLength];
        for (int i = 0; i < endLength; i++) {
            res[row-1][i] = triangle.get(triangle.size()-1).get(i);
        }
        for (int i = row-2; i >= 0; i--) {
            res[i] = new int[--endLength];
            for (int j = 0; j < res[i].length; j++) {
                int v = triangle.get(i).get(j);
                int v1 = res[i+1][j] + v;
                int v2 = res[i+1][j+1] + v;
                res[i][j] = Math.min(v1, v2);
            }
        }
        return res[0][0];
    }

}
