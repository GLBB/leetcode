package cn.gl.newketiba;

public class NC105 {

    public int search (int[] nums, int target) {
        // write code here
        int left = 0;
        int right = nums.length - 1;
        int midIdx = 0;
        int targetIdx = -1;
        while (left <= right) {
            midIdx = (left + right) / 2;
            if (nums[midIdx] == target) {
                targetIdx = midIdx;
                break;
            } else if (nums[midIdx] > target) {
                right = midIdx - 1;
            } else {
                left = midIdx + 1;
            }
        }
        if (targetIdx == -1) {
            return -1;
        } else {
            while (targetIdx >= 1 && nums[targetIdx - 1] == nums[targetIdx]) {
                targetIdx--;
            }
        }
        return targetIdx;
    }
}
