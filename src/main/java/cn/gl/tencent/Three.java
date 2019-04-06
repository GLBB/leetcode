package cn.gl.tencent;

import java.util.Scanner;

public class Three {

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNextLine()) {//注意while处理多个case
//            int num = Integer.parseInt(scanner.nextLine());
//            int[] action = new int[num];
//            String[] sarr1 = scanner.nextLine().split(" ");
//            for (int i = 0; i < sarr1.length; i++) {
//                action[i] = Integer.parseInt(sarr1[i]);
//            }
//            int[] coins = new int[num];
//            String[] sarr2 = scanner.nextLine().split(" ");
//            for (int i = 0; i < sarr2.length; i++) {
//                coins[i] = Integer.parseInt(sarr2[i]);
//            }
//        }

//        int[] actions = {8, 5, 10};
//        int[] coins = {1, 1, 2};
//        int r = solution(actions, coins);
//        System.out.println();
    }

    public static int solution(int[] actions, int[] coins){
        int sum = 0;
        for (int i = 1; i <= actions.length; i++) {
            sum = 0;
            int alreadyAction =  0;
            for (int j = 0; j < i; j++) {
                alreadyAction += actions[j];
                sum+= coins[j];
            }
            for (int j = i; j < actions.length; j++) {
                if (alreadyAction < actions[j]){
                    break;
                }
            }
        }
        return sum;
    }
}
