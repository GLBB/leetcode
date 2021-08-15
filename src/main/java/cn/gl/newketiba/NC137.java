package cn.gl.newketiba;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class NC137 {

    public static void main(String[] args) {
        String expr = "((10+2)*10-(100-(10+20*10-(2*3)))*10*1*2)-2";
        int solve = new NC137().solve(expr);
        System.out.println(solve);
    }

    private Map<Character, Integer> map = new HashMap<>();

    private void initOperator() {
        map.put('+', 1);
        map.put('-', 1);
        map.put('*', 2);
        map.put('(', 3);
    }

    public int solve (String s) {
        initOperator();
        LinkedList<Long> numStack = new LinkedList<>();
        LinkedList<Character> opStack = new LinkedList<>();
        int i = 0;
        if (s.startsWith("-")) {
            s = "0" + s;
        }
        while (i < s.length()) {
            char ch = s.charAt(i);
            if (map.keySet().contains(ch) || ')' == ch) {
                // op
                if (ch == '(') {
                    if (i < s.length() - 1 && s.charAt(i+1) == '-') {
                        numStack.push(0L);
                    }
                    opStack.push(ch);
                } else if (ch == ')') {
                    while(opStack.peek() != '(') {
                        calc(numStack, opStack);
                    }
                    opStack.pop();
                } else {
                    if (!opStack.isEmpty() && opStack.peek() != '(') {
                        int curPriority = map.get(ch);
                        int peekPriority = map.get(opStack.peek());
                        if (curPriority <= peekPriority) {
                            calc(numStack, opStack);
                        }
                    }
                    opStack.push(ch);
                }
                i++;
            } else {
                // num
                Long num = getNumber(s, i);
                int length = String.valueOf(num).length();
                i = i + length;
                numStack.push(num);
            }
        }
        while (!opStack.isEmpty()) {
            calc(numStack, opStack);
        }
        int res = (int) (numStack.pop() + 0);
        return res;
    }

    private void calc(LinkedList<Long> numStack, LinkedList<Character> opStack) {
        long num2 = numStack.pop();
        long num1 = numStack.pop();
        char ch = opStack.pop();
        long res = getResult(ch, num1, num2);
        numStack.push(res);
    }

    private Long getNumber(String s, int idx) {
        StringBuilder sb = new StringBuilder();
        while (idx < s.length() && isNumber(s.charAt(idx))) {
            sb.append(s.charAt(idx));
            idx ++;
        }
        return Long.parseLong(sb.toString());
    }

    private boolean isNumber(char ch) {
        return ch - '0' >= 0 && ch - '9' <= 0;
    }

    private long getResult(char ch, long num1, long num2) {
        switch (ch) {
            case '+': return num1 + num2;
            case '-': return num1 - num2;
            case '*': return num1 * num2;
            default: throw new RuntimeException();
        }
    }
    
}
