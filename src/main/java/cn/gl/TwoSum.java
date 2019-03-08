package cn.gl;


import java.util.Arrays;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        int target = 6;
        Solution solution = new TwoSum().new Solution();
        int[] ints = solution.twoSum(nums, target);
        System.out.println(Arrays.toString(ints));
    }

    class Solution {
        public int[] twoSum(int[] nums, int target) {
            int[] indics = new int[2];
            for (int i = 0; i < nums.length - 1; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] + nums[j] == target) {
                        indics[0] = i;
                        indics[1] = j;
                        return indics;
                    }
                }
            }
            return null;
        }
    }
}


/**
 * hashmap 解决方案
 * class Solution {
 *     public int[] twoSum(int[] nums, int target) {
 *         Map<Integer, Integer> diffIndex = new HashMap();
 *         int[] indices = new int[2];
 *         for(int i=0; i<nums.length; i++) {
 *             if(diffIndex.get(nums[i]) != null){
 *                 indices[0] = diffIndex.get(nums[i]);
 *                 indices[1] = i;
 *                 return indices;
 *             }
 *             diffIndex.put(target - nums[i], i);
 *         }
 *         return null;
 *     }
 * }
 *
 *
 * */