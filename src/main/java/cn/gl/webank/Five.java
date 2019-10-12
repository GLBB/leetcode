package cn.gl.webank;

import java.math.BigInteger;
import java.util.Scanner;


public class Five {

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNextLine()) {
//            String s = scanner.nextLine();
//            solution(s);
//        }
        solution("3");
    }

    private static void solution(String s) {
        Integer num = Integer.valueOf(s);
        BigInteger sum = BigInteger.valueOf(num);
        for (int i = num - 1; i > 1; i--) {
            sum = sum.multiply(BigInteger.valueOf(i));
        }
        sum = sum.mod(BigInteger.valueOf(10).pow(6).add(BigInteger.valueOf(3)));
        System.out.println(sum);
    }
}
