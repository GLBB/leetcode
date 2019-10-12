package cn.gl.offer_niuke;

import java.util.LinkedList;

public class IsPopOrder {

    public static void main(String[] args) {
        int x = 5>0?null:1;
        System.out.println(x);
    }

    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA.length == 0 && popA.length == 0 || pushA == null && popA == null)
            return true;
        if (pushA == null || popA == null || pushA.length == 0 || popA.length == 0)
            return false;
        LinkedList<Integer> stack = new LinkedList<>();
        int idx = 0;
        for (int i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            int peek =  pushA[i];
            while (peek == popA[idx]){
                idx++;
                if (stack.size() ==  0)
                    return false;
                else {
                    stack.pop();
                    if (stack.size() > 0){
                        peek = stack.peek();
                    }else {
                        break;
                    }
                }
            }
        }
        if (stack.size() == 0){
            return true;
        }else {
            return false;
        }
    }
}
