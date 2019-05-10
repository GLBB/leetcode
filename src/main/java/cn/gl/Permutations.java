package cn.gl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        backtrace(res, nums, list, set);

        return res;
    }

    public void backtrace(List<List<Integer>> res, int[] nums, List<Integer> list, Set<Integer> set){
        if (list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i]))
                continue;
            list.add(nums[i]);
            set.add(nums[i]);
            backtrace(res, nums, list, set);
            list.remove(list.size()-1);
            set.remove(nums[i]);
        }

    }
}
