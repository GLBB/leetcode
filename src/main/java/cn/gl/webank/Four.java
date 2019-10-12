package cn.gl.webank;

import java.math.BigInteger;
import java.util.Scanner;

public class Four {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            String s = scanner.nextLine();
            solution(s);
        }
    }

    public static void solution(String nStr){
        Integer n = 1;
        try {
            n = Integer.valueOf(nStr);
        }catch (Exception e){
            System.out.println("");
        }
        BigInteger res = BigInteger.valueOf(1);
        for (int i = 2; i <= n; i++) {
            res = res.multiply(BigInteger.valueOf(i));
        }
        String s = res.toString();
        for (int i = s.length() -1; i >= 0 ; i--) {
            if (s.charAt(i) != '0') {
                System.out.println(s.charAt(i) + "");
                break;
            }
        }
    }
}
