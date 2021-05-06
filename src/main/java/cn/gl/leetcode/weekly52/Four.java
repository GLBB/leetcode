package cn.gl.leetcode.weekly52;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Four {

    public static void main(String[] args) {
        int[][] rooms = {{1,4},{2,3},{3,5},{4,1},{5,2}};
        int[][] queries = {{2,3},{2,4},{2,5}};
        Four four = new Four();
        int[] ints = four.closestRoom(rooms, queries);
        System.out.println(Arrays.toString(ints));
    }

    public int[] closestRoom(int[][] rooms, int[][] queries) {
        int[] result = new int[queries.length]; 
        for (int i = 0; i < queries.length; i++) {
            int seq = queries[i][0];
            int min = queries[i][1];
            List<Integer> idSet = filter(rooms, min);
            if (idSet.size() == 0) {
                result[i] = -1;
                continue;
            }
            idSet.sort(Integer::compareTo);
            int targetSeq = 0;
            int minAbs = Math.abs(idSet.get(0) - seq);
            for (int j = 1; j < idSet.size(); j++) {
                if (Math.abs(idSet.get(j) - seq) < minAbs) {
                    minAbs = Math.abs(idSet.get(j) - seq);
                    targetSeq = j;
                }
            }
            result[i] = idSet.get(targetSeq);
        }
        return result;
    }
    
    public List<Integer> filter(int[][] rooms,int min) {
        List<Integer> set = new ArrayList<>();
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i][1] >= min) {
                set.add(rooms[i][0]);
            }
        }
        return set;
    }
}
