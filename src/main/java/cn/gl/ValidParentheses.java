package cn.gl;

import java.util.LinkedList;
import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        ValidParentheses solution = new ValidParentheses();
        String para1 = "{[]}";
        System.out.println(solution.isValid(para1));
    }

    public boolean isValid(String s) {
        if ("".equals(s)) return true;
        LinkedList<Character> stack = new LinkedList<>();
        stack.push(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            Character peek = stack.peek();

            if (c == ')' || c == '}' || c==']') {
                if (stack.size() == 0) return false;
                if (    c == ')' && peek.equals('(') ||
                        c == '}' && peek.equals('{')||
                        c== ']' && peek.equals('[')
                ) {
                    stack.pop();
                    continue;
                }else return false;
            }else stack.push(c);
        }

        if (stack.size() == 0) return true;
        else return false;
    }
}
