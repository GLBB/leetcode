package cn.gl;

public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {

        int[] p1 = {1,1,2};

        RemoveDuplicatesFromSortedArray solution = new RemoveDuplicatesFromSortedArray();
        int i = solution.removeDuplicates(p1);
        System.out.println(i);
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int curIdx = 1;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] == nums[i]) {
                continue;
            }else {
                count++;
                if (curIdx == i) curIdx++;
                else {
                    nums[curIdx++] = nums[i];
                }
            }
        }
//        for (int i = curIdx; i < nums.length; i++) {
//
//        }

        return count;
    }
}
