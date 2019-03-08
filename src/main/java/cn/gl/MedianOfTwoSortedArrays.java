package cn.gl;


/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 *
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 *
 * You may assume nums1 and nums2 cannot be both empty.
 *
 * Example 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * The median is 2.0
 * Example 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * The median is (2 + 3)/2 = 2.5
 */
@SuppressWarnings("ALL")
public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        var solution = new MedianOfTwoSortedArrays();
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        double result = solution.findMedianSortedArrays(nums1, nums2);
        System.out.println(result);
    }



    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length == 0)
            return medianSortedArray(nums2);
        else if (nums2.length == 0)
            return medianSortedArray(nums1);

        if (nums1[nums1.length - 1] <= nums2[0])
            return medianSortedArrays(nums1, nums2);
        else if (nums1[0] >= nums2[nums2.length - 1])
            return medianSortedArrays(nums2, nums1);

        int total = nums1.length + nums2.length;
        if (total % 2 == 0) {
            int imin = 0, imax = nums1.length - 1;
            while (imin <= imax) {
                int i = (imin + imax) / 2;
                int j = total / 2 - i;
                if (nums1[i - 1] <= nums2[j] && nums2[j - 1] <= nums1[i]) {
                    int leftMax = Math.max(nums1[i -1], nums2[j-1]);
                    int rightMin = Math.min(nums1[i], nums2[j]);
                    return (leftMax + rightMin) / 2;
                } else if (nums1[i - 1] >= nums2[j]) {
                    imax = i - 1;
                } else if (nums1[j - 1] >= nums1[i]) {
                    imin = i + 1;
                } else {
                    System.out.println("bukeneng");
                }
            }
        } else {
            int imin = 0, imax = nums1.length - 1;
            while (imin <= imax) {
                int i = (imin + imax) / 2;
                int j = (total - 1) / 2 - i;


                if (nums1[i - 1] <= nums2[j] && nums2[j - 1] <= nums1[i]) {
                    int rightMin = Math.min(nums1[i], nums2[j]);
                    return rightMin;
                } else if (nums1[i - 1] >= nums2[j]) {
                    imax = i - 1;
                } else if (nums1[j - 1] >= nums1[i]) {
                    imin = i + 1;
                } else {
                    System.out.println("bukeneng");
                }
            }
        }



        return 0;
    }

    /**
     * 寻找 nums 数组中的中位数
     * @param nums
     * @return
     */
    private double medianSortedArray(int[] nums){
        // 在 nums2 中寻找中位数,
        // 如果有偶数个元素，中位数
        int medianIdx = nums.length / 2;
        if (nums.length % 2 == 0) {
            return (nums[medianIdx - 1] + nums[medianIdx]) / 2;
        } else {
            return nums[medianIdx];
        }
    }

    /**
     * nums1，nums2 数组是有序的，且nums1 最大元素 小于等于 nums2 最小元素
     * 相等于将这两个数组排序成一个数组X, 然后返回数组X 的中位数。
     * @param nums1
     * @param nums2
     * @return
     */
    private double medianSortedArrays(int[] nums1, int[] nums2){
        int total = nums1.length + nums2.length;
        int medianIdx = total/2;
        if (total % 2 == 0) {
            if (medianIdx <= nums1.length - 1) {
                return (nums1[medianIdx -1] + nums1[medianIdx]) / 2;
            } else if (medianIdx == nums1.length) {
                return (nums1[nums1.length - 1] + nums2[0]) / 2;
            } else {
                medianIdx = medianIdx - nums1.length;
                return (nums2[medianIdx - 1] + nums2[medianIdx]) / 2;
            }
        } else {
            if (medianIdx <= nums1.length - 1) {
                return nums1[medianIdx];
            } else {
                medianIdx = medianIdx - nums1.length;
                return nums2[medianIdx];
            }
        }
    }




}
