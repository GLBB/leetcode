package cn.gl.g;

import java.util.Scanner;

public class One {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            String[] s1 = s.split(" ");
            solution(Integer.valueOf(s1[0]));
        }
    }
    private static void solution(int n){
        for (int i = n; i > 1; i--) {
            boolean flag = false;
            for (int j = 2; j < i/2; j++) {
                if (i % j == 0) {
                    flag = true;
                }
            }
            if (!flag) {
                System.out.println(i);
                return;
            }
        }
    }
}
