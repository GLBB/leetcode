package cn.gl.offer_niuke;

public class FindGreatestSumOfSubArray {

    public int FindGreatestSumOfSubArray(int[] array) {
        if (array == null && array.length == 0)
            return 0;
        int curSum = array[0];
        int maxSum = curSum;
        for (int i = 1; i < array.length; i++) {
            if (curSum < 0) {
                curSum = array[i];
            }else {
                curSum += array[i];
            }

            if (curSum > maxSum){
                maxSum = curSum;
            }
        }
        return maxSum;
    }
}
