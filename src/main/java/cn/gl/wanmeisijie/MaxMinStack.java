package cn.gl.wanmeisijie;

import java.util.Scanner;

public class MaxMinStack {



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            solution(line);
        }

    }

    public static void solution(String line){
        String[] strArr = line.split(" ");
        if (strArr.length <= 1) {
            return;
        }
        int[] stack = new int[strArr.length - 1];
        int max=Integer.MIN_VALUE, min=Integer.MAX_VALUE;
        for (int i = 1; i < strArr.length-1; i++) {
            int v = Integer.parseInt(strArr[i]);
            stack[i-1] = v;
            if (v > max){
                max = v;
            }
            if (v < min){
                min = v;
            }
        }
        System.out.println(max+","+min);
    }



}

class Stack{
    int[] stack;
    int idx;
    Integer max;
    Integer min;
    Integer priorMax;
    Integer priorMin;

    public void push(int data){
        if (idx < stack.length)
            stack[idx++] = data;
        else
            throw new RuntimeException();
    }

    public void pop(){
        if (idx>0)
            idx--;
        else
            throw new RuntimeException();
    }

    public int min(){
        if (idx==0)
            return 0;
        int min = stack[0];
        for (int i = 1; i < idx; i++) {
            if (stack[idx] < min)
                min = stack[idx];
        }
        return min;
    }
}
