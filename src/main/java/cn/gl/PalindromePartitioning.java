package cn.gl;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * 看的别人代码，待以后重做
 */
public class PalindromePartitioning {

    public static void main(String[] args) {
        String str = "cdd";
        List<List<String>> partition = partition(str);
        System.out.println();
    }

    public static List<List<String>> partition(String s) {
        if(s == null || s.length() == 0)
            return Collections.emptyList();
        ArrayList<List<String>> res = new ArrayList<>();
        ArrayList<String> imRes = new ArrayList<>();
        helper(s, imRes, res);
        return res;
    }

    public static void helper(String s, ArrayList<String> sub, ArrayList<List<String>> res){
        if (s.length() ==  0){
            res.add(new ArrayList<>(sub));
            return;
        }
        for (int i = 1; i <= s.length(); i++) {
            String subStr = s.substring(0, i);
            if (!isPalindrome(subStr))
                continue;
            sub.add(subStr);
            String leftStr = s.substring(i, s.length());
            helper(leftStr, sub, res);
            sub.remove(sub.size() - 1); // 为什么是移除最后一个元素
        }

    }

    public static boolean isPalindrome(String str){
        if ("".equals(str))
            return false;
        int hp = 0, tp = str.length()-1;
        while (hp < tp && (hp != tp || hp != tp -1)) {
            if (str.charAt(hp) == str.charAt(tp)) {
                hp ++;
                tp --;
            }else {
                return false;
            }
        }
        return true;
    }

}
