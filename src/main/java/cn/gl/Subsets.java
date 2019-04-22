package cn.gl;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(subsets(nums));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums==null || nums.length == 0)
            return res;
        helper(nums, res, new ArrayList<>(), 0);
        return res;
    }


    public static void helper(int[] nums, List<List<Integer>> res, ArrayList<Integer> list, int idx) {
        res.add(new ArrayList<>(list));
        for (int i = idx; i < nums.length; i++) {
            list.add(nums[i]);
            helper(nums, res, list, i+1);
            list.remove(list.size()-1);
        }
    }
}
