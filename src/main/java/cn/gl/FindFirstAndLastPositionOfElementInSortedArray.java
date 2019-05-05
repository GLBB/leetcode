package cn.gl;

public class FindFirstAndLastPositionOfElementInSortedArray {

    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        if (nums == null || nums.length == 0)
            return res;
        int low = 0, high = nums.length -1;
        while (low <= high){
            int middle = (low + high)/2;
            if (nums[middle] == target){
                int left = middle;
                while (left >=0 && nums[left] == nums[middle]){
                    left--;
                }
                res[0] = left + 1;
                int right = middle;
                while (right < nums.length && nums[right] == nums[middle]){
                    right++;
                }
                res[1] = right-1;
                return res;
            }else if (nums[middle] < target){
                low = middle + 1;
            }else {
                high = middle - 1;
            }
        }
        return res;
    }
}
