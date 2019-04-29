package cn.gl;

public class SearchInRotatedSortedArrayII {

    public static void main(String[] args) {
        int[] nums =  {1,3,1,1,1};
        System.out.println(search(nums, 3));
    }

    public static boolean search(int[] nums, int target) {
        int low = 0, high = nums.length-1;
        while (low <= high){
            int middle = (low+high)/2;
            if (nums[middle] == target)
                return true;
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
        return false;
    }

}
