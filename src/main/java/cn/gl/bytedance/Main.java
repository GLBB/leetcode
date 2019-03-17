package cn.gl.bytedance;

import java.util.Scanner;

public class Main {

    static int[] coins = {64, 16, 4, 1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String first = scanner.nextLine();
        int spend = Integer.parseInt(first);

        int r = solution(spend);
        System.out.println(r);
    }

    public static int solution(int spend){
        int money = 1024 - spend;
        int count = 0;
        while (money > 0) {
            for (int i = 0; i < coins.length; i++) {
                while (money >= coins[i]){
                    money -= coins[i];
                    count++;
                }
            }
        }

        return count;
    }
}
