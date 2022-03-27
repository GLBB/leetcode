package cn.gl.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 */
public class L15 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 3) {
            return result;
        }

        Arrays.sort(nums);



        for (int i = 0; i < nums.length; ) {

            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int threeSum = nums[i] + nums[j] + nums[k];
                if (threeSum == 0) {
                    List<Integer> item = new ArrayList<>();
                    item.add(nums[i]);
                    item.add(nums[j]);
                    item.add(nums[k]);
                    result.add(item);
                    j++;
                    while (j < nums.length && nums[j] == nums[j - 1]) {
                        j++;
                    }
                } else if (threeSum < 0) {
                    // j++
                    j++;
                    while (j < nums.length && nums[j] == nums[j - 1]) {
                        j++;
                    }

                } else {
                    k --;
                    while (k >= 0 && nums[k] == nums[k + 1]) {
                        k --;
                    }

                }
            }

            i++;
            while(i < nums.length && nums[i] == nums[i - 1]) {
                i++;
            }
        }

        return result;

    }
}
