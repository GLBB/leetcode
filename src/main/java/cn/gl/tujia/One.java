package cn.gl.tujia;

import java.math.BigInteger;
import java.util.Scanner;

public class One {

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNextLine()) {
//            String s = scanner.nextLine();
//            String[] s1 = s.split(" ");
//            solution(Integer.valueOf(s1[0]), Long.valueOf(s1[1]), Integer.valueOf(s1[2]));
//        }

        solution(36, 252, 10);
    }

    private static void solution(int m, long s, int t){
        int maxS = 0;
        int i = 0;
        while (i < t) {
            // i eq second
            if (m >= 10) {
                m -= 10;
                maxS += 50;
                i++;
            }else {
                // 查看剩余魔法值，积累到10 花费的时间
                int lm = 10 - m;
                int lmt = 0;
                if (lm % 4 == 0){
                    lmt = lm / 4;
                }else {
                    lmt = lm / 4 + 1;
                }
                // 走过的距离
                int ss = (lmt+1)* 13;
                if (ss > 50){
                    i ++;
                    maxS += 13;
                }else {
                    m = 4 * lmt - 10;
                    i = i + lmt + 1;
                    maxS += 50;
                }
            }
            // 判断是否大于 s
            if (maxS > s){
                System.out.println("Yes");
                System.out.println(i);
                return;
            }
        }
        System.out.println("No");
        System.out.println(maxS);
    }
}
