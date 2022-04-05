package cn.gl.leetcode;

public class L53 {

    public int maxSubArray(int[] nums) {
        if (nums.length <= 0) {
            return 0;
        }
        int maxSum = nums[0];
        int curSum = 0;
        for (int i=0; i < nums.length; i++) {
            if (curSum < 0) {
                curSum = nums[i];
            } else {
                curSum += nums[i];
            }

            if (curSum > maxSum) {
                maxSum = curSum;
            }
        }
        return maxSum;
    }
}
