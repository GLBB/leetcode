package cn.gl.yitu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Three {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String fline = scanner.nextLine();
            int n = Integer.valueOf(fline);
            String sline = scanner.nextLine();
            String[] s = sline.split(" ");
            List<Long> list = new ArrayList<>();
            for (int i = 0; i < s.length; i++) {
                list.add(Long.valueOf(s[i]));
            }
            solution(list);
        }
    }

    private static void solution(List<Long> list) {
        int count = 0;
        Collections.sort(list);
        boolean[] rem = new boolean[list.size()];
        int temp = list.size() / 2;
        for (int i = 0; i < temp; i++) {
            long curV = list.get(i);
            for (int j = temp; j < list.size(); j++) {
                if (!rem[j] && list.get(j) >= curV*2) {
                    rem[i] = true;
                    rem[j] = true;
                    count++;
                    break;
                }
            }
        }
        for (int i = 0; i < rem.length; i++) {
            if (!rem[i]){
                count++;
            }
        }
        System.out.println(count);

    }
}
