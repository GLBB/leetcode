package cn.gl._360;

import java.util.Scanner;

public class Three {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            String[] s1 = s.split(" ");
            int m = Integer.valueOf(s1[1]);
            int n = Integer.valueOf(s1[0]);
            if (n == 0 || m == 0)
                System.out.println("0.000");
            String s2 = scanner.nextLine();
            String[] s3 = s2.split(" ");
            int[] arr = new int[s3.length];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.valueOf(s3[i]);
            }
            solution(arr, m);
        }

    }

    private static void solution(int[] arr, int m){
        int maxSum = 0;
        int maxSumLeft = -1;
        int maxSumRight = -1;
        for (int i = 0; i <= arr.length - m; i++) {
            int sum = 0;
            for (int j = i; j < i+m; j++) {
                sum += arr[j];
            }
            if (sum > maxSum) {
                maxSumLeft = i;
                maxSumRight = i+m - 1;
                maxSum = sum;
            }
        }
        double avg = maxSum*1.0/m;
        if (maxSumLeft != -1) {
            maxSumLeft -= 1;
            while (maxSumLeft >= 0 && arr[maxSumLeft] > avg) {
                maxSum += arr[maxSumLeft];
                maxSumLeft--;
                m++;
                avg = maxSum*1.0/m;
            }
        }
        if (maxSumRight != -1) {
            maxSumRight += 1;
            while (maxSumRight  < arr.length && arr[maxSumRight] > avg ) {
                maxSum += arr[maxSumRight];
                maxSumRight++;
                m++;
                avg = maxSum*1.0/m;
            }
        }
        System.out.printf("%.3f", avg);



    }

}
