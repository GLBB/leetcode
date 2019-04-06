package cn.gl.tencent;

import java.util.Arrays;
import java.util.Scanner;

public class First {

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNextLine()) {//注意while处理多个case
//            String firstLine = scanner.nextLine();
//            String[] strArr = firstLine.split(" ");
//            int m = Integer.parseInt(strArr[0]);
//            int n = Integer.parseInt(strArr[1]);
//            int[] coins = new int[n];
//            for (int i = 0; i < n; i++) {
//                coins[i] = Integer.parseInt(scanner.nextLine());
//            }
//            int solution = solution(m, coins);
//            System.out.println(solution);
//        }

        int[] coins = {2,3, 7};
        int solution = solution(10, coins);
        System.out.println();
    }

    public static int solution(int m, int[] coins){
        if (m == 0) {
            return 0;
        }
        if (coins.length == 0 || coins[0] > 1)
            return -1;

        int[] result = new int[m+1];
        result[0] = 0;
        for (int i = 1; i < result.length; i++) {
            int[] temp = new int[coins.length];
            int idx = 0;
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    temp[j] = result[i-coins[j]] + 1;
                    idx = j;
                } else {
                    break;
                }
            }
            int min = findMin(temp, idx);
            result[i] = min;
        }
        Arrays.sort(result);
        return result[result.length-1];
    }

    public static int findMin(int[] arr, int semi){
        int min = arr[0];
        for (int i = 1; i <= semi; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        return min;
    }
}
