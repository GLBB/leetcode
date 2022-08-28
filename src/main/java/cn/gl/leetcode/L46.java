package cn.gl.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class L46 {

    public static void main(String[] args) {
        List<List<Integer>> permute = new L46().permute(new int[]{1, 2, 3});
        System.out.println(permute);
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> seq = new LinkedList<>();
        List<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toList());
        dfs(result, seq, set);
        return result;
    }

    public void dfs(List<List<Integer>> result, LinkedList<Integer> seq, List<Integer> set) {
        if (set.isEmpty()) {
            // add result
            LinkedList<Integer> tempList = new LinkedList<>(seq);
            result.add(tempList);
            return;
        }

        for (Integer value : set) {
            LinkedList<Integer> tempSet = new LinkedList<>(set);
            tempSet.remove(value);
            seq.add(value);
            dfs(result, seq, tempSet);
            tempSet.add(value);
            seq.remove(value);
        }
    }
}
