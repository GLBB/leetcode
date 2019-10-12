package cn.gl.qianxi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class TwO {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String fline = scanner.nextLine();
            String sline = scanner.nextLine();
            String[] arrStr = sline.split(" ");
            int[] values = new int[arrStr.length];
            for (int i = 0; i < arrStr.length; i++) {
                values[i] = Integer.valueOf(arrStr[i]);
            }
            String tline = scanner.nextLine();
            int q = Integer.valueOf(tline);
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < q; i++) {
                String line = scanner.nextLine();
                String[] lineArr = line.split(" ");
                int[] query = new int[3];
                query[0] = Integer.valueOf(lineArr[0]);
                query[1] = Integer.valueOf(lineArr[1]);
                query[2] = Integer.valueOf(lineArr[2]);
                solution(values, query, list);
            }
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }
        }
    }

    private static void solution(int[] values, int[] query, List<Integer> res) {
        int from = query[0] - 1;
        int to = query[1] - 1;
        int count = 0;
        for (int i = from; i <= to; i++) {
            if (values[i] == query[2]) {
                count++;
            }
        }
        res.add(count);
    }
}
