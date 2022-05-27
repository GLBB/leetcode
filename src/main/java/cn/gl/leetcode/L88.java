package cn.gl.leetcode;

/**
 * 88. 合并两个有序数组
 */
public class L88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int idx1 = m - 1;
        int idx2 = n - 1;

        int resIdx = nums1.length - 1;

        while (idx1 >= 0 && idx2 >= 0) {
            if (nums1[idx1] > nums2[idx2]) {
                nums1[resIdx] = nums1[idx1];
                idx1 --;
            } else {
                nums1[resIdx] = nums2[idx2];
                idx2 --;
            }
            resIdx --;
        }

        while(idx2 >= 0) {
            nums1[resIdx] = nums2[idx2];
            idx2 --;
            resIdx --;
        }
    }
}
