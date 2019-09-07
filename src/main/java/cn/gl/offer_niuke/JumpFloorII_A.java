package cn.gl.offer_niuke;

public class JumpFloorII_A {

    public int JumpFloorII(int target) {
        if (target <= 0)
            return 0;
        else if (target == 1)
            return 1;
        else if (target == 2)
            return 2;
        int[] res = new int[target+1];
        res[0] = 0; res[1] = 1; res[2] = 2;
        for (int i = 3; i < res.length; i++) {
            int sum = 0;
            for (int j = 0; j < i; j++) {
                sum += res[j];
            }
            res[i] = sum + 1;
        }
        return res[target];

    }
}
