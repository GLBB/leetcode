package cn.gl;

import java.util.Arrays;

public class SortColors {

    public static void main(String[] args) {
        int[] arr = {2, 2};
        swap(arr, 1, 1);
        System.out.println(Arrays.toString(arr));
    }

    public void sortColors(int[] nums) {
        int lp = -1, hp = nums.length;
        for (int i = 0; i < hp; i++) {
            switch (nums[i]){
                case 0: swap(nums, ++lp, i);
                        break;
                case 1: break;
                case 2: swap(nums, i, --hp);
                        i--;break;
            }
        }
    }

    public static void swap(int[] nums, int idx1, int idx2){
        if (idx1==idx2)
            return;
        nums[idx1] ^= nums[idx2];
        nums[idx2] ^= nums[idx1];
        nums[idx1] ^= nums[idx2];
    }
}
