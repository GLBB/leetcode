package cn.gl.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 1. 两数之和
 */
public class L1 {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = map.get(nums[i]);
            if (list == null) {
                list = new ArrayList<Integer>();
                map.put(nums[i], list);
            }
            list.add(i);
        }

        Arrays.sort(nums);

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                List<Integer> leftList = map.get(nums[left]);
                int leftIdx = leftList.remove(0);
                List<Integer> rightList = map.get(nums[right]);
                int rightIdx = rightList.remove(0);
                int tempLeft = Math.min(leftIdx, rightIdx);
                int tempRight = Math.max(leftIdx, rightIdx);
                return new int[]{tempLeft, tempRight};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return null;
    }
}
