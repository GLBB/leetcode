package cn.gl.mihayou;

import java.util.Scanner;

public class TWO {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            int row =Integer.valueOf(s.split(" ")[0]) ;
            int col = Integer.valueOf(s.split(" ")[1]);
            char[][] arr = new char[row][col];
            for (int i = 0; i < row; i++) {
                String rowStr = scanner.nextLine();
                for (int j = 0; j < rowStr.length(); j++) {
                    arr[i][j] = rowStr.charAt(j);
                }
            }
            String opt = scanner.nextLine();
            String[] s1 = opt.split(" ");
            solution(arr, Integer.valueOf(s1[0]),
                    Integer.valueOf(s1[1]), Integer.valueOf(s1[2]), Integer.valueOf(s1[3]));
        }
    }

    private static void solution(char[][] arr, Integer row1, Integer col1, Integer row2, Integer col2) {
        // swap two point, ckeck two point, has 3, move 再次判断
        char temp = arr[row1][col1];
        arr[row1][col1] = arr[row2][col2];
        arr[row2][col2] = temp;

    }

    private static void check(char[][] arr ,int row1, int col1, ResWrapper resWrapper) {
        char x =  arr[row1][col1];
        if (x == '0')
            return;
        int left = col1-1, right = col1+1, up = row1-1, down = row1+1;
        while (left>= 0 && arr[row1][left] == x){
            left--;
        }
        while (right < arr[0].length && arr[row1][right] == x){
            right ++;
        }
        while(up >= 0 && arr[up][col1] == x) {
            up--;
        }
        while (down < arr.length && arr[down][col1] == x) {
            down++;
        }
        int rowCount = col1 - left - 1 + right - col1 - 1;
        int colCount = row1 - up - 1 + down - row1 - 1;
        if (rowCount >= 3 && colCount >= 3) {



        }


    }



    static class ResWrapper{
        int res;
    }

}
