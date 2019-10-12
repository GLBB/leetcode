package cn.gl.offer_niuke;

public class NumberOf1 {

    public static void main(String[] args) {

    }

    public int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            int bit = n & 0x1;
            if (bit == 1)
                count++;
            n = n >>> 1;
        }
        return count;
    }

}
