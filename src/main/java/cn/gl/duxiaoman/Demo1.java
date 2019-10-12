package cn.gl.duxiaoman;

import java.util.Scanner;

public class Demo1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstLine = scanner.nextLine();
        String[] firstArr = firstLine.split(" ");
        Integer targetX = Integer.parseInt(firstArr[0]);
        Integer targetY = Integer.parseInt(firstArr[1]);
        Integer lineNumber = Integer.parseInt(firstArr[2]);
        Integer[][] blocks = new Integer[lineNumber][2];
        for (int i = 0; i < lineNumber; i++) {
            String s = scanner.nextLine();
            String[] s1 = s.split(" ");
            blocks[i][0] = Integer.parseInt(s1[0]);
            blocks[i][1] = Integer.parseInt(s1[1]);
        }
        Integer res = solution(targetX, targetY, blocks);
        System.out.println(res);
    }

    public static Integer solution(Integer targetX, Integer targetY, Integer[][] blocks){
        boolean[][] road = new boolean[1001][1001];
        for (int i = 0; i < blocks.length; i++) {
            int idxX = blocks[i][0] + 500;
            int idxY = blocks[i][1] + 500;
            road[idxX][idxY] = true;
        }
        //
        return 0;
    }

}
