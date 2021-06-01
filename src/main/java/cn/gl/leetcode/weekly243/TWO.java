package cn.gl.leetcode.weekly243;

public class TWO {

    public static void main(String[] args) {
        String x = "1234";
        System.out.println(x.substring(0, 0));
    }

    public String maxValue(String n, int x) {
        boolean positive = false;
        if (n.charAt(0) == '-') {
            positive = false;
        } else {
            positive = true;
        }
        String num = positive ? n : n.substring(1);
        if (positive) {
            return getMax(num, x);
        } else {
            return "-" + getMin(num, x);
        }
    }
    
    private String getMax(String num, int x) {
        for (int i = 0; i < num.length(); i++) {
            int item = num.charAt(i) - '0';
            if (x > item) {
                return num.substring(0, i) + x + num.substring(i);
            }
        }
        return num + x;
    }
    
    private String getMin(String num, int x) {
        for (int i = 0; i < num.length(); i++) {
            int item = num.charAt(i) - '0';
            if (x < item) {
                return num.substring(0, i) + x + num.substring(i);
            }
        }
        return num + x;
    }
}
