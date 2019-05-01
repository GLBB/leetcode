package cn.gl;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

    public static void main(String[] args) {
        List<List<Integer>> combine = combine(4, 3);
        System.out.println(combine);
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        helper(n, 1, k, res, new ArrayList<>());
        return res;
    }

    public static void helper(int n, int x, int k, List<List<Integer>> res, List<Integer> list){
        if (list.size() == k){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = x; i <= n; i++) {
            list.add(i);
            helper(n, i+1, k, res, list);
            list.remove(list.size()-1);
        }
    }

}
