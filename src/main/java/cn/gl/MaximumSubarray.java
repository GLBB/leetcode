package cn.gl;

public class MaximumSubarray {

    public static void main(String[] args) {
        int[] arr = {1,2,-1,-2,2,1,-2,1,4,-5,4};
        int res = maxSubArray(arr);
        System.out.println(res);
    }

    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int maxSum = nums[0];
        int curSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (curSum + nums[i] < nums[i]) {
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
