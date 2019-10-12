package cn.gl.mihayou;

import java.util.Arrays;
import java.util.Scanner;

public class One {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            String s1 = scanner.nextLine();
            String[] s2 = s1.split(" ");
            int[] arr = new int[s2.length];
            for (int i = 0; i < s2.length; i++) {
                arr[i] = Integer.valueOf(s2[i]);
            }
            solution(arr);

        }

//        int [] arr = {3, 7, 0, 0};
//        solution(arr);
    }

    private static void solution(int[] arr){
        Arrays.sort(arr);
        int count = 0;
        int idx = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0){
                count++;
            }else {
                idx = i;
                break;
            }
        }
        if (idx == -1){
            System.out.println("YES+" + count);
            return;
        }
        int temp = count;
        for (int i = idx; i < arr.length-1; i++) {
            if (arr[i] + 1 == arr[i+1]){
                continue;
            }else {
                if (temp > 0){
                    arr[i] = arr[i]  + 1;
                }else {
                    System.out.println("NO+"+count);
                    return;
                }
            }
        }
        System.out.println("YES+" + count);

    }
}
