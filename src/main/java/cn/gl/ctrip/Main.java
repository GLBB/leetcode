package cn.gl.ctrip;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static String resolve(String expr) {
        if (expr == null || expr.length() == 0)
            return expr;
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();
        int low = 0, high = expr.length() - 1;
        while (low < high){
            while (expr.charAt(low) != '('){
                low++;
            }
            left.add(low++);
            while (expr.charAt(high) != ')') {
                high--;
            }
            right.add(high--);
        }
        char[] chars = expr.toCharArray();
        for (int i = left.size()-1; i >= 0; i--) {
            int start = left.get(i);
            int end = right.get(i);
            int mid = (start + end)/2;
            for (int j = start; j <= mid; j++) {
                // last idx , end -( j - start)
                char temp = chars[j];
                chars[j] = chars[end - j + start];
                chars[end - j + start] = temp;
            }
        }
        return new String(chars);
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;

        String _expr;
        try {
            _expr = in.nextLine();
        } catch (Exception e) {
            _expr = null;
        }

        res = resolve(_expr);
        System.out.println(res);
    }
}