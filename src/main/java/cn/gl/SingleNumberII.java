package cn.gl;

public class SingleNumberII {

    public int singleNumber(int[] nums) {
        if (nums == null)
            return 0;
        int[] count = new int[32];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < 32; j++) {
                count[j] += nums[i] >> j & 0x1;
            }
        }
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result |= count[i]%3<<i;
        }

        return result;
    }
}
