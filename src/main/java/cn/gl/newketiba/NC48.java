package cn.gl.newketiba;

/**
 * 旋转数组寻找目标值
 */
public class NC48 {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param nums int整型一维数组 
     * @param target int整型 
     * @return int整型
     */
    public int search (int[] nums, int target) {
        // write code here
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] ==  target) {
                return mid;
            }
            if (nums[low] < nums[high]) {
                if (nums[mid] < target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else {
                if (nums[mid] > target) {
                    high = mid - 1;
                } else {
                    if (target <= nums[high]) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }
            }
        }
        return -1;
    }
}
