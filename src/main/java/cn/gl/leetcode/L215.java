package cn.gl.leetcode;

/**
 * 215. 数组中的第K个最大元素
 */
public class L215 {

    public int findKthLargest(int[] nums, int k) {
        int targetIdx = nums.length - k;
        int result = findKthLargest(nums, 0, nums.length - 1, targetIdx);
        return result;
    }

    private int findKthLargest(int[] nums, int left, int right, int targetIdx) {
        int pivotIdx = findPivot(nums, left, right);
        if (targetIdx == pivotIdx) {
            return nums[pivotIdx];
        } else if (targetIdx > pivotIdx) {
            return findKthLargest(nums, pivotIdx + 1, right, targetIdx);
        } else {
            return findKthLargest(nums, left, pivotIdx - 1, targetIdx);
        }
    }

    private int findPivot(int[] nums, int start, int end) {
        int i = start + 1;
        int j = end;
        while (i <= j) {
            while (i <= end && nums[start] >= nums[i]) {
                i ++;
            }
            while (j > start && nums[start] <= nums[j]) {
                j --;
            }
            if (j > i) {
                swap(nums, i, j);
            }
        }
        swap(nums, start, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
