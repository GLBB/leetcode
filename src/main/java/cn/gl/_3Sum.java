package cn.gl;

import java.util.*;

/**
 * O(n^3) 时间超限
 */
public class _3Sum {

    public static void main(String[] args) {
        _3Sum solution = new _3Sum();
        int[] para1 = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = solution.threeSum(para1);
        System.out.println(lists);

    }

    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<Triplets> set = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i+1; j < nums.length - 1; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        Triplets triplets = new Triplets(nums[i], nums[j], nums[k]);
                        set.add(triplets);
                    }
                }
            }
        }
        List<List<Integer>> lists = toReuslt(set);
        return lists;
    }

    private List<List<Integer>> toReuslt(HashSet<Triplets> set){
        List<List<Integer>> list = new ArrayList<>();
        Iterator<Triplets> iterator = set.iterator();
        while (iterator.hasNext()) {
            Triplets next = iterator.next();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < next.nums.length; i++) {
                temp.add(next.nums[i]);
            }
            list.add(temp);
        }
        return list;
    }

    class Triplets{
        int[] nums = new int[3];

        public Triplets(int x, int y, int z) {
            nums[0] = x;
            nums[1] = y;
            nums[2] = z;
            Arrays.sort(nums);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Triplets triplets = (Triplets) o;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != triplets.nums[i]) {
                    return false;
                }
            }
            return true;
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(nums);
        }
    }
}
