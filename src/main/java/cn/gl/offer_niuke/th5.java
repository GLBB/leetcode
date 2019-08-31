package cn.gl.offer_niuke;

import java.util.Stack;

public class th5 {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        // if stack 2 not empty, pop, else stack1 pop, stack2 push, stack2 pop
        if (!stack2.empty()) {
            return stack2.pop();
        }else {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }
    }
}
