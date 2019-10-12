package cn.gl.yitu;

import java.util.Scanner;


public class TWO {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String fline = scanner.nextLine();
            int n = Integer.valueOf(fline);
            int[] h = new int[n];
            int[] v = new int[n];
            for (int i = 0; i < n; i++) {
                String line = scanner.nextLine();
                String[] lineArr = line.split(" ");
                h[i] = Integer.valueOf(lineArr[0]);
                v[i] = Integer.valueOf(lineArr[1]);
            }
            solution(h, v);
        }
    }

    private static void solution(int[] h, int[] v){
        int max = 0;
        int n = h.length;
        int[] rec = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = i-1; j >= 0; j--) {
                if (h[i] < h[j]) {
                    rec[j] += v[i];
                    if (rec[j] > max) {
                        max = rec[j];
                    }
                    break;
                }
            }
            for (int j = i+1; j < n; j++) {
                if (h[i] < h[j]){
                    rec[j] += v[i];
                    if (rec[j] > max) {
                        max = rec[j];
                    }
                    break;
                }
            }
        }
        System.out.println(max);
    }
}
