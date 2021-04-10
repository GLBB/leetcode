package cn.gl.newketiba;

import java.util.LinkedList;

public class NC52 {

    public static void main(String[] args) {
        System.out.println(isValid("()"));
    }

    public static boolean isValid (String s) {
        // write code here
        LinkedList<Character> stack = new LinkedList<>();
        for (Character chr : s.toCharArray()) {
            if (chr.equals('(') || chr.equals('[') || chr.equals('{')) {
                stack.push(chr);
            } else {
                Character peek = stack.peek();
                if (peek == null) {
                    return false;
                }
                switch (peek) {
                    case '(': 
                        if (chr.equals(')')) {
                            stack.pop();
                        } else {
                            return false;
                        }
                        break;
                    case '[':
                        if (chr.equals(']')) {
                            stack.pop();
                        } else {
                            return false;
                        }
                        break;
                    case '{':
                        if (chr.equals('}')) {
                            stack.pop();
                        } else {
                            return false;
                        }
                        break;
                }
            }
        }
        return stack.size() == 0; 
    }
}
