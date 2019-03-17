package cn.gl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * [-1,-5,-5,-3,2,5,0,4]
 * -7
 */
public class _4Sum {

    public static void main(String[] args) {
        _4Sum solution = new _4Sum();
        int[] arr1 = {1, 0, -1, 0, -2, 2};
        int para1 = 0;


        int[] arr2 = {-3,-2,-1,0,0,1,2,3};
        int para2 = 0;

        int[] arr3 = {-1,0,1,2,-1,-4};
        int para3 = -1;

        int[] arr4 = {-1,-5,-5,-3,2,5,0,4};
        int para4 = -7;

        List<List<Integer>> lists = solution.fourSum(arr4, para4);
        System.out.println(lists);


    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            if (i>=1 && nums[i] == nums[i-1]) continue;

            for (int j = i+1; j < nums.length-2; j++) {
                if (j-1 != i && nums[j] == nums[j-1]) continue;
                int low = j + 1, high = nums.length - 1;
                while (low < high) {
                    int sum = nums[i] + nums[j] + nums[low] + nums[high];
                    if (sum == target) {
                        List<Integer> solution = new ArrayList<>();
                        Collections.addAll(solution,nums[i], nums[j], nums[low], nums[high]);
                        list.add(solution);
                        while (low<high && nums[low+1] == nums[low]) low++;
                        while (low < high && nums[high] == nums[high-1]) high--;
                    } if (sum<target) low++;
                    else high--;
                }
            }

        }

        return list;
    }
}
