package cn.gl.newketiba;

import java.util.HashSet;
import java.util.Set;

public class NC41 {

    /**
     *
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public int maxLength (int[] arr) {
        // write code here
        if (arr == null || arr.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        int maxLength = 0;
        int slow = 0;
        int fast = 0;
        while (fast < arr.length) {
            if (set.contains(arr[fast])) {
                if (set.size() > maxLength) {
                    maxLength = set.size();
                }
                set.remove(arr[slow]);
                slow++;
                continue;
            } else {
                set.add(arr[fast]);
                fast++;
            }
        }
        return maxLength;
    }
}
