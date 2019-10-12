package cn.gl.yitu;

import java.util.Scanner;

public class One {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String fline = scanner.nextLine();
            int m =  Integer.valueOf(fline.split(" ")[0]);
            int n =  Integer.valueOf(fline.split(" ")[1]);
            int b =  Integer.valueOf(fline.split(" ")[2]);
            int[][] homes = new int[m][3];
            for (int i = 0; i < m; i++) {
                String line = scanner.nextLine();
                String[] lineArr = line.split(" ");
                homes[i][0] = Integer.valueOf(lineArr[0]);
                homes[i][1] = Integer.valueOf(lineArr[1]);
                homes[i][2] = Integer.valueOf(lineArr[2]);
            }
            int[][] cars = new int[n][2];
            for (int i = 0; i < n; i++) {
                String line = scanner.nextLine();
                String[] lineArr = line.split(" ");
                cars[i][0] = Integer.valueOf(lineArr[0]);
                cars[i][1] = Integer.valueOf(lineArr[1]);
            }
            solution(homes, cars, b);
        }
    }

    private static void solution(int[][] homes, int[][] cars, int b){
        int max = 0;
        for (int i = 0; i < homes.length; i++) {
            for (int j = 0; j < cars.length; j++) {
                int bPrice = homes[i][2] + cars[j][1];
                if (b < bPrice) {
                    continue;
                }
                int time = homes[i][1]/cars[j][0];
                int temp = 10 * homes[i][0] - time;
                if (temp > max){
                    max = temp;
                }
            }
        }
        System.out.println(max);
    }
}
