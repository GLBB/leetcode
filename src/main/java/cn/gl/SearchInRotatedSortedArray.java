package cn.gl;

/**
 * 只能用于数组中没有重复的值
 */
public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        int low = 0, high = nums.length-1;
        while (low <= high){
            int middle = (low+high)/2;
            if (nums[middle] == target)
                return middle;
            if (nums[low] <= nums[middle] ){
                // low -- middle sorted
                if (nums[low] <= target && target < nums[middle]){
                    high = middle - 1;
                }else {
                    low = middle + 1;
                }
            }else {
                // middle -- hight sorted
                if (nums[middle] < target && target <= nums[high]){
                    low = middle + 1;
                }else {
                    high = middle - 1;
                }
            }
        }
        return -1;
    }
}
