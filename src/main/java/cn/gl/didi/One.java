package cn.gl.didi;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class One {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String fLine = scanner.nextLine();
            Integer n = Integer.valueOf(fLine.split(" ")[0]);
            Integer m = Integer.valueOf(fLine.split(" ")[1]);
            ArrayList<Integer[]> list = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                String line = scanner.nextLine();
                Integer[] arr = new Integer[2];
                arr[0] = Integer.valueOf(line.split(" ")[0]);
                arr[1] = Integer.valueOf(line.split(" ")[1]);
                list.add(arr);
            }
            solution(n, list);
        }
    }

    private static void solution(Integer n, ArrayList<Integer[]> list){
        int[] res = new int[n];
        HashSet<Integer> one = new HashSet<>();
        HashSet<Integer> two = new HashSet<>();
        for (int i = 0; i < list.size(); i++) {
            Integer[] integers = list.get(i);
            for (int j = 0; j < i; j++) {

            }
        }
    }
}
