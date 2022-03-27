package cn.gl.leetcode;

import java.util.Arrays;

/**
 * 912. 排序数组
 */
public class L912 {
    public static void main(String[] args) {
        int[] nums = new int[]{5,2,3,1};
        new L912().sortArray(nums);
        System.out.println(Arrays.toString(nums));
    }

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int left, int right) {
        int pivot = findPivot(nums, left, right);
        if (left < pivot - 1) {
            quickSort(nums, left, pivot - 1);
        }
        if (pivot + 1 < right) {
            quickSort(nums, pivot + 1, right);
        }
    }

    private int findPivot(int[] nums, int left, int right) {
        int i = left + 1;
        int j = right;

        while (i <= j) {
            while (i<=right && nums[i] <= nums[left]) {
                i ++;
            }
            while(j > left && nums[j] >= nums[left]) {
                j--;
            }
            if (j > i) {
                swap(nums, i, j);
            }

        }
        swap(nums, left, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
