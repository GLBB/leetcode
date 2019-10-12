package cn.gl.offer_niuke;

public class Power {

    public double Power(double base, int exponent) {
        if (base == 0)
            return 0;
        else if (exponent == 0)
            return 1;
        boolean nagative = false;
        long exponentAbs = Math.abs(exponent);
        if (exponent < 0) {
            nagative = true;
        }
        double res = 1;
        for (int i = 0; i < exponentAbs; i++) {
            res = res * base;
        }
        if (nagative) {
            res = 1.0/res;
        }
        return res;
    }

}
