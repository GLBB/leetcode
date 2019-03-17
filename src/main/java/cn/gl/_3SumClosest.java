package cn.gl;

import java.util.Arrays;

/**
 * [1,1,1,0]
 * -100
 *
 * [0,2,1,-3]
 * 1
 *
 * [1,1,-1,-1,3]
 * -1
 *
 * [-1,2,1,-4]
 * 1
 *
 * [1,2,4,8,16,32,64,128]
 * 82
 */
public class _3SumClosest {

    public static void main(String[] args) {
        _3SumClosest solution = new _3SumClosest();
        int[] para1 = {-1, 2, 1, -4};
        int t1 = 1;
        int[] para2 = {1,1,1,0};
        int t2 = -100;
        int[] para3 = {0,2,1,-3};
        int t3 = 1;
        int[] para4 = {1,1,-1,-1,3};
        int t4 = -1;
        int[] para5 = {1,2,4,8,16,32,64,128};
        int t5 = 82;
        int i = solution.threeSumClosest(para5, t5);
        System.out.println(i);
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minDistance = Integer.MAX_VALUE;
        int minSum = 0;
        for (int i = 0; i < nums.length; i++) {
            int low = i+1, high = nums.length - 1;
            while (low < high) {
                int sum = nums[i] + nums[low] + nums[high];
                int distance = getDistance(sum, target);
                if (distance < minDistance) {
                    minDistance = distance;
                    minSum = sum;
                    if (minDistance==0) return minSum;
                    if (sum > target) high--;
                    else low++;
                } else {
                    if (sum > target) high--;
                    else low++;
                }
            }
        }
        return minSum;
    }

    private int getDistance(int sum, int target){
        return sum > target? sum-target: target - sum;
    }


}
