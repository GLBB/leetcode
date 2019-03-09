package cn.gl;

import java.util.StringJoiner;
import java.util.stream.Collectors;

public class PalindromeNumber {

    public static void main(String[] args) {
        PalindromeNumber solution = new PalindromeNumber();
        int x1 = 121;
        int x2 = -121;
        int x3 = 10;
        boolean palindrome = solution.isPalindrome(x1);
        System.out.println(palindrome);
    }


    /**
     * 先将整数 x 预处理
     * 中间向两边比较
     * 返回结果
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        String prepare = prepare(x);
        int middle = prepare.length()/2;
        int start = 0;
        while (start < middle) {
            if (prepare.charAt(start) != prepare.charAt(prepare.length() - 1 -start)) {
                return false;
            }
            start++;
        }
        return true;
    }

    private String prepare(int x){
        String str = x + "";
//        StringJoiner stringJoiner = new StringJoiner("#", "#", "#"); leetcode 识别不了 stringJoiner
        StringBuilder builder = new StringBuilder();
        builder.append("#");
        for (int i = 0; i < str.length(); i++) {
            builder.append(str.charAt(i)+"#");
        }
        return builder.toString();
    }
}
