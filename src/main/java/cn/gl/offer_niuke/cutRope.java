package cn.gl.offer_niuke;

public class cutRope {

    public static void main(String[] args) {
        cutRope s = new cutRope();
        int res = s.cutRope(5);
        System.out.println(res);
    }

    boolean flag = true;

    public int cutRope(int target) {
        int max = 0;
        if (flag){
            if (target == 1 && target == 2)
                return 1;
            max = 0;
            flag = false;
        }else {
            if (target == 1)
                return 1;
            else if (target == 2)
                return 2;
            max = target;
        }
        for (int i = 1; i <= target / 2; i++) {
            int value = cutRope(i) * cutRope(target - i);
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

}
