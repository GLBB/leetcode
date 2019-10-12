package cn.gl.tencent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Four {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            String[] s1 = s.split(" ");
            int n = Integer.valueOf(s1[0]);
            int k = Integer.valueOf(s1[1]);
            String s2 = scanner.nextLine();
            String[] s3 = s2.split(" ");
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < s3.length; i++) {
                list.add(Integer.valueOf(s3[i]));
            }
//            ArrayList<Integer> back = new ArrayList<>(list);
//            Collections.sort(back);
            for (int i = 0; i < k; i++) {
                int minIdx = -1;
                int min = -1;
                int firstIdx = -1;
                for (int j = 0; j < list.size(); j++) {
                    if (list.get(j) != 0){
                        min = list.get(j);
                        firstIdx = j;
                        minIdx = j;
                        break;
                    }
                }
                for (int j = firstIdx+1; j < list.size(); j++) {
                    if (list.get(j) == 0)
                        continue;
                    if (min > list.get(j)) {
                        min = list.get(j);
                        minIdx = j;
                    }
                }
                for (int j = 0; j < list.size(); j++) {
                    if (list.get(j) == 0)
                        continue;
                    int value = list.get(j) - min;
                    list.set(j, value);
                }
                System.out.println(min);
            }

        }
    }
}
