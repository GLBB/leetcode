package cn.gl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _3Sum_2 {

    public static void main(String[] args) {
        _3Sum_2 solution = new _3Sum_2();
        int[] para1 = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = solution.threeSum(para1);
        System.out.println(lists);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i==0 || nums[i] != nums[i-1]) {
                int low = i + 1, high = nums.length - 1;
                int sum = 0 - nums[i];
                while (low < high) {
                    int _2sum = 0;
                    if ((_2sum = nums[low] + nums[high]) == sum) {
                        list.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        while (low < high && nums[low+1] == nums[low]) low++;
                        while (low<high && nums[high-1] == nums[high]) high--;
                        low++;high--;
                    }else if (_2sum < sum) low++;
                    else high--;
                }
            }
//             如果nums[i]>0 break;
            if (nums[i] > 0) break;
        }
        return list;
    }

}
