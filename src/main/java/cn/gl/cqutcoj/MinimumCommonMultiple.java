package cn.gl.cqutcoj;

import java.util.ArrayList;
import java.util.Scanner;

public class MinimumCommonMultiple {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> result = new ArrayList<>();
        while (scanner.hasNext()){
            String s = scanner.nextLine();
            String[] input = s.split(" ");
            int m = Integer.parseInt(input[0]);
            int n = Integer.parseInt(input[1]);

            int r = getMinimumCommonMultiple(m, n);
//            result.add(r);
            System.out.println(r);
        }

//        for (Integer i: result) {
//
//            System.out.println(i);
//        }
    }

    private static int getMinimumCommonMultiple(int m, int n){
        if (m == 0 || n==0) return 0;

        int x = m * n;
        int i = Math.max(m, n);
        while (i<x) {
            if (i%m==0 && i%n==0) return i;
            i++;
        }

        return x;
    }
}
