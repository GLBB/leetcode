package cn.gl;

public class MaximumProductSubarray2 {

    public static void main(String[] args) {

    }

    public int maxProduct(int[] nums) {
        int[] maxArr = new int[nums.length];
        int[] minArr = new int[nums.length];
        int max = nums[0];
        maxArr[0] = nums[0];
        minArr[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int v1 = maxArr[i-1] * nums[i];
            int v2 = minArr[i-1] * nums[i];
            maxArr[i] = v1>v2?(v1>nums[i]?v1:nums[i]):(v2>nums[i]?v2:nums[i]);
            if (maxArr[i] > max) {
                max = maxArr[i];
            }
            minArr[i] = Math.min(Math.min(v1,v2), nums[i]);
        }
        return max;
    }
}
