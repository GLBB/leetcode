package cn.gl.cqutcoj;

import java.util.Scanner;

public class TriplePalindromeNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            boolean triplePalindrome = isTriplePalindrome(Integer.parseInt(s));
            if (triplePalindrome) {
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }

    public static boolean isTriplePalindrome(int n){
        boolean palindrome = isPalindrome(n);

        if (isPalindrome(n) && isPalindrome(n*n) && isPalindrome(n*n*n)) {
            return true;
        }

        return false;
    }

    public static boolean isPalindrome(int n){
        String x = n + "";
        x = prepare(x);
        int middle = x.length()/2;
        int offset = 1;
        while (middle + offset < x.length()) {
            if (x.charAt(middle-offset) != x.charAt(middle+offset)) {
                return false;
            }
            offset++;
        }
        return true;
    }

    public static String prepare(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("#");
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i) + "#");
        }
        return sb.toString();
    }
}
