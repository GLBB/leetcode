package cn.gl.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 20. Valid Parentheses
 */
public class L20 {

    public boolean isValid(String s) {

        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        LinkedList<Character> stack = new LinkedList<>();

        boolean valid = true;

        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if (map.keySet().contains(ch)) {
                stack.addFirst(ch);
            } else {
                if (stack.isEmpty()) {
                    valid = false;
                    break;
                }
                Character peek = stack.removeFirst();
                Character peekValue = map.get(peek);
                if (peekValue != ch) {
                    valid = false;
                    break;
                }

            }
        }

        if (!stack.isEmpty()) {
            valid = false;
        }

        return valid;
    }
}
