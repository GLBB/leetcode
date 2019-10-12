package cn.gl.wangyi;

import java.util.Scanner;

public class One {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            String[] s1 = s.split(" ");
            solution(Long.valueOf(s1[0]), Long.valueOf(s1[1]));
        }
//        solution(54 ,36);
    }

    private static void solution(long a, long b){
        long gcd = gcd(a, b);
        long x = a * b / gcd;
        System.out.println(gcd + " " + x);
    }

    private static long gcd(long a, long b){
        long m = a>b? a: b;
        long n = a>b? b : a;
        while (n != 0) {
            long z = m % n;
            m = n > z? n : z;
            n = n > z? z: n;
        }
        return m;
    }
}
