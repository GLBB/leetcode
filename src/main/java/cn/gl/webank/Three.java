package cn.gl.webank;

import java.util.Scanner;

public class Three {

    public static void main(String[] args) {
//        Scanner scanner =  new Scanner(System.in);
//        while (scanner.hasNextLine()) {
//            String line = scanner.nextLine();
//            String[] strArr = line.split(" ");
//            int m = Integer.parseInt(strArr[0]);
//            int n = Integer.parseInt(strArr[1]);
//            int k = Integer.parseInt(strArr[2]);
//            solution(m, n, k);
//        }

        solution(3, 2, 2);
    }

    public static void solution(int m, int n, int k){
        int count = 0;
        while (m > k) {
            m = m -k;
            count += n;
        }
        count += n;
        System.out.println(count);
    }

    public static void solution2(int m, int n, int k){
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = n;
        }
        int count = 0;
        while (true) {
            // findmax
            int max = arr[0];
            int maxIdx = 0;
            for (int i = 0; i < k; i++) {
                for (int j = 1; j < arr.length; j++) {
                    if (max < arr[i]){
                        max = arr[i];
                        maxIdx = i;
                    }
                }
            }


        }


    }
}
