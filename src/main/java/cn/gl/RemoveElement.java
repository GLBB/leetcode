package cn.gl;

public class RemoveElement {

    public static void main(String[] args) {
        RemoveElement solution = new RemoveElement();
        int[] p1 = {3,2,2,3};
        int v1 = 3;

        int[] p2 = {0,1,2,2,3,0,4,2};
        int v2 = 2;

        int i = solution.removeElement(p2, v2);
        System.out.println();
    }

    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) return 0;

        int curIdx = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                count++;
            }else{
                if (curIdx != i) nums[curIdx++] = nums[i];
                else curIdx++;
            }
        }

        return nums.length - count;
    }
}
