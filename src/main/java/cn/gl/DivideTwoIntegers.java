package cn.gl;


/**
 * 给定被除数和除数，返回结果为商
 * 不能使用乘法，除法，mod 运算
 * 当溢出时，返回 2^31-1
 *
 *
 * 未通过，不想做了
 */
public class DivideTwoIntegers {

    public static void main(String[] args) {
        DivideTwoIntegers solution = new DivideTwoIntegers();
        int d1 = 10, d11 = 3;
        int d2 = 7, d22 = -3;
        int d3 = -2147483648, d33 = -1;
        int d4 = -2147483648, d44 = 1;
        int divide = solution.divide(d4, d44);
        System.out.println(divide);
    }

    public int divide(int dividend, int divisor) {
        int temp1 = Math.abs(dividend);
        int temp2 = Math.abs(divisor);

        int count = 0;
        if (temp1 < 0 && temp2 < 0) { // 说明 tem1 == Integer.MIN_VALUE;
            return 1;
        }else if (temp1 < 0 && divisor < 0) {
            while (temp1 < temp2) {
                temp1+=temp2;
                count++;
                if (count==Integer.MAX_VALUE) return Integer.MAX_VALUE;
            }
            return count;
        }else if (temp1 < 0 && divisor > 0) {
            while (temp1 < temp2){
                temp1+=temp2;
                count++;
            }
            return --count;
        }


        while (temp1 >= temp2){
            temp1 -= temp2;
            count++;
            if (count== Integer.MAX_VALUE) return Integer.MAX_VALUE;
        }
        if (dividend < 0 && divisor > 0 ||
            dividend > 0 && divisor < 0
        ) return -count;
        else return count;



    }
}
