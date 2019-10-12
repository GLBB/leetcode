package cn.gl.offer_niuke;

import java.util.LinkedList;

public class MinStack {

    LinkedList<Integer> stack = new LinkedList<>();
    LinkedList<Integer> minStack = new LinkedList<>();

    public void push(int node) {
        stack.push(node);
        if (minStack.size() == 0){
            minStack.push(node);
        }else {
            Integer peek = minStack.peek();
            if (node < peek) {
                minStack.push(node);
            }else {
                minStack.push(peek);
            }
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }

}
