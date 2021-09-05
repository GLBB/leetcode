package cn.gl.newketiba;

/**
 * NC128 接雨水问题
 */
public class NC128 {

    /**
     * max water
     * @param arr int整型一维数组 the array
     * @return long长整型
     */
    public long maxWater (int[] arr) {
        // write code here
        long result = 0L;
        int start = 0;
        int end = arr.length -1;
        while (start < end) {
            int min = Math.min(arr[start], arr[end]);
            while (start < end && arr[start] <= min) {
                result += min - arr[start];
                start++;
            }

            while (start < end && arr[end] <= min) {
                result += min - arr[end];
                end --;
            }
        }
        return result;
    }
}
