package cn.gl.ali;

import java.util.ArrayList;
import java.util.Scanner;

public class One {

    static String calculate(int m, int k) {
        int[] arr = new int[m];
        int r1 = cal1(arr, m);
        return "";
    }

    public static int cal1(int[] arr, int m){
        if (m ==  3)
            return 4;
        arr[0] = 2;
        arr[1] = 3;
        arr[2] = 4;
        for (int i = 0; i < m; i++) {
            arr[i] = arr[i-3] + arr[i-2];
        }
        return arr[m];
    }

    public static int cal2(int m) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(0);
        int year = 0;
        while (list.size() < m){
            for (int i = 0; i < list.size(); i++) {
                int cur = list.get(i);
                list.set(i, cur+1);
            }
            // find >= 2
            int count = 0;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) >= 2) {
                    count++;
                }
            }
            while (count>0){
                list.add(0);
                count--;
            }
            year++;
        }
        return year+2019;
    }

    public static int cal3(int[] arr){
        // flip
        for (int i = 0; i < arr.length; i++) {
//            arr[i] =
        }
        return 0;
    }

    public static int flip(int x){
        String str = x+"";
        int intervel = 0;
        int count = 0;
        while (count < str.length()/2){

        }
        return 0;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String[] line = in.nextLine().split(",");
        int m = Integer.valueOf(line[0]);
        int k = Integer.valueOf(line[1]);;
        System.out.println(calculate(m, k));

    }

}
