package cn.gl.leetcode;

public class L451 {

    public static void main(String[] args) {
        String result = new L451().addStrings("11", "123");
        System.out.println(result);
    }

    public String addStrings(String num1, String num2) {
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();

        StringBuilder sb = new StringBuilder();
        int minLength = num1.length() > num2.length() ? num2.length() : num1.length();

        int surplus = 0;
        for (int i = 0; i < minLength; i++) {
            int v1 = num1.charAt(i) - '0';
            int v2 = num2.charAt(i) - '0';

            int result = v1 + v2 + surplus;
            if (result >= 10) {
                surplus = 1;
            } else {
                surplus = 0;
            }
            sb.append(result % 10);
        }

        if (num1.length() > num2.length()) {
            for (int i = minLength; i < num1.length(); i++) {
                int v1 = num1.charAt(i) - '0';
                int result = surplus + v1;
                if (result >= 10) {
                    surplus = 1;
                } else {
                    surplus = 0;
                }
                sb.append(result % 10);
            }
        }

        if (num1.length() < num2.length()) {
            for (int i = minLength; i < num2.length(); i++) {
                int v2 = num2.charAt(i) - '0';
                int result = surplus + v2;
                if (result >= 10) {
                    surplus = 1;
                } else {
                    surplus = 0;
                }
                sb.append(result % 10);
            }
        }

        if (surplus == 1) {
            sb.append(1);
        }
        return sb.reverse().toString();
    }
}
