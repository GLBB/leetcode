package cn.gl.cqutcoj;

import java.math.BigInteger;
import java.util.Scanner;

public class ArbitraryLengthIntegerAddition {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String s1 = scanner.nextLine();
            String s2 = scanner.nextLine();
            String result = getResult(s1, s2);
            System.out.println(result);
        }
    }

    public static String getResult(String s1, String s2){
        s1 = s1.replace("@", "");
        s2 = s2.replace("@", "");
        BigInteger b1 = new BigInteger(s1);
        BigInteger b2 = new BigInteger(s2);
        return b1.add(b2).toString();
    }
}
