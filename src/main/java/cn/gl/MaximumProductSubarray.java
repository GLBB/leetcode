package cn.gl;

/**
 * Memory Limit Exceeded
 */
public class MaximumProductSubarray {

    public static void main(String[] args) {

    }

    public int maxProduct(int[] nums) {
        int[][] result = new int[nums.length][];
        int max = Integer.MIN_VALUE;
        for(int i=0; i<result.length; i++) {
            result[i] = new int[nums.length-i];
            result[i][0] = nums[i];
            if(result[i][0] > max) {
                max = result[i][0];
            }
        }
        for(int i=nums.length-2; i>=0; i--) {
            for(int j=nums.length-i-1; j>=1; j--) {
                result[i][j] = result[i+1][j-1] * nums[i];
                if (result[i][j] > max) {
                    max = result[i][j];
                }
            }
        }

        return max;
    }

    private void prepare(int[] nums, int[][] result) {

    }
}
