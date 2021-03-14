package cn.gl.newketiba;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class MinNDemo {

    public static void main(String[] args) {

    }

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if (input == null || input.length == 0 || k <= 0 || input.length < k) {
            return new ArrayList<>();
        }
        LinkedHashSet<Integer> resultSet = new LinkedHashSet<>();
        // quick sort
        Integer maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < input.length; i++) {
            if (resultSet.size() < k) {
                resultSet.add(input[i]);
                maxValue = maxV(resultSet);
            } else if (resultSet.size() == k && input[i] < maxValue) {
                resultSet.remove(maxValue);
                maxValue = maxV(resultSet);
                resultSet.add(input[i]);
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (Integer v : resultSet) {
            result.add(v);
        }
        return result;
    }

    private Integer maxV(LinkedHashSet<Integer> set) {
        Integer maxV = Integer.MIN_VALUE;
        for (Integer v : set) {
            maxV = v > maxV ? v : maxV;
        }
        return maxV;
    }


}


