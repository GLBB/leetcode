package cn.gl.newketiba;

public class NC19 {

    /**
     * max sum of the subarray
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public int maxsumofSubarray (int[] arr) {
        // write code here
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        int i = 0;
        int j = arr.length - 1;
        int maxSum = sum;
        while (i <= j) {
            if (arr[i] <= arr[j]) {
                sum = sum - arr[i];
                i++;
            } else {
                sum = sum - arr[j];
                j--;
            }
            if (maxSum < sum) {
                maxSum = sum;
            }
        }
        return maxSum;
    }
}
