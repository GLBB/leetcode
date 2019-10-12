package cn.gl.didi;

import java.util.ArrayList;
import java.util.Scanner;

public class TWO {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String f = scanner.nextLine();
            int m = Integer.valueOf(f.split(" ")[0]);
            int n = Integer.valueOf(f.split(" ")[1]);
            int[] arr = new int[m];
            String s = scanner.nextLine();
            String[] s1 = s.split(" ");
            for (int i = 0; i < s1.length; i++) {
                arr[i] = Integer.valueOf(s1[i]);
            }
            solution(arr, n);
        }

    }

    private static void solution(int[] arr, int n){
        ArrayList<Integer> sums = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (i + n <= arr.length) {
                int sum = 0;
                for (int j = i; j < i+n; j++) {
                    sum += arr[j];
                }
                sums.add(sum);
            }else {
                int firstPart = n - (arr.length - i - 1) - 1;
                int sum = 0;
                for (int j = 0; j < firstPart; j++) {
                    sum += arr[j];
                }
                for (int j = i; j < arr.length; j++) {
                    sum+= arr[j];
                }
                sums.add(sum);
            }
        }
        if (sums.size() <= 0) {
            return;
        }
        int min = sums.get(0);
        for (int i = 1; i < sums.size(); i++) {
            if (sums.get(i) < min) {
                min = sums.get(i);
            }
        }
        System.out.println(min);
    }
}
