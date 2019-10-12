package cn.gl.offer_niuke;

public class th8 {

    public int RectCover(int target) {
        if (target <= 0){
            return 0;
        } else if (target == 1)
            return 1;
        else if (target == 2)
            return 2;
        int[] res = new int[target+1];
        res[0] = 0;
        res[1] = 1;
        res[2] = 2;
        for (int i = 3; i <= target; i++) {
            res[i] = res[i - 1] + res[i -2];
        }

        return res[target];
    }

}
