package cn.gl;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        List<List<Integer>> lists = combinationSum(candidates, 7);
        System.out.println(lists);

    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<>(), candidates, target, 0, 0);
        return res;
    }

    public static void helper(List<List<Integer>> res, List<Integer> list,int[] candidates, int target, int x, int sum){
        if (sum == target){
            res.add(new ArrayList<>(list));
            return;
        }else if (sum > target){
            return;
        }
        for (int i = x; i < candidates.length; i++) {
            list.add(candidates[i]);
//            System.out.println(list);
            helper(res, list, candidates, target, i, sum+candidates[i]);
            list.remove(list.size()-1);
        }
    }

}
