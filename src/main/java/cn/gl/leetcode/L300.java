package cn.gl.leetcode;

/**
 * 300. 最长递增子序列
 */
public class L300 {

    public int lengthOfLIS(int[] nums) {
        int[] countArr = new int[nums.length];
        countArr[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            int curLength = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && curLength < countArr[j] + 1) {
                    curLength = countArr[j] + 1;
                }
            }
            countArr[i] = curLength;
        }

        int max = countArr[0];
        for (int i = 1; i < countArr.length; i++) {
            if (max < countArr[i]) {
                max = countArr[i];
            }
        }
        return max;
    }
}
