package cn.gl.zhaoshang;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Demo1 {

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while (in.hasNextLine()) {
//            String str = in.nextLine();
//            solution(str);
//        }

//        solution();

    }

    /**
     * RRRRRLRLRL
     * @param str
     */
    private static void solution(String str){
        int[] robots = new int[str.length()];
        for (int i = 0; i < robots.length; i++) {
            robots[i] = 1;
        }
        int[] res = new int[str.length()];
        BigInteger num = BigInteger.valueOf(10).pow(100);
        // find RL idx
        int[] RLidxs = findRL(str);
//        BigInteger bigInteger = new BigInteger()
        for (int i = 0; i < res.length; i++) {
            // i th robot
            // i -> L, i-1 in set?
            if (RLidxs[i] != 0) {
                res[i] = res[i] + 1;
            }else {
                int count = 0;
                int idx = -1;
                if (str.charAt(i) == 'L'){
                    for (int j = i; j >=0 ; j--) {
                        if (str.charAt(i) == 'R') {
                            count = i - j;
                            break;
                        }
                    }
                    idx = i - count;
                }else {
                    for (int j = i; j < res.length; j++) {
                        if (RLidxs[j] != 0) {
                            count = j - i;
                            break;
                        }
                    }
                    idx = i + count;
                }
                BigInteger mod = num.subtract(BigInteger.valueOf(count)).mod(BigInteger.valueOf(2));
                if (mod.equals(BigInteger.ZERO)){
                    res[idx] +=1;
                }else {
                    res[idx+1] += 1;
                }
            }
        }
        //0 0 0 0 3 3 1 1 1 1
        for (int i = 0; i < res.length - 1; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println(res[res.length -1]);
    }

    private static int[] findRL(String str){
        int[] idxs = new int[str.length()];
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == 'R' && str.charAt(i+1) == 'L'){
                idxs[i] = 1;
                idxs[i+1] = 2;
            }
        }
        return idxs;
    }



}
