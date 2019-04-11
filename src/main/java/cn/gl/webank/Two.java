package cn.gl.webank;

import java.util.Scanner;

public class Two {

    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String fline = scanner.nextLine();
            String sline = scanner.nextLine();
            String[] sArr = sline.split(" ");
            for (int i = 0; i < sArr.length; i++) {
                int num = Integer.parseInt(sArr[i]);
                solution(num);
            }
        }

//        solution(3);
    }

    public static void solution(int m){
        int count = 0;
        while (m != 1) {
            if (isC(m)){
                m = 3 * m + 1;
            }else {
                m = m / 2;
            }
            count ++;
        }
        System.out.println(count);

    }

    /**
     * 奇数返回 true
     * @param num
     * @return
     */
    public static boolean isC(int num){
        if (num % 2 == 1) {
            return true;
        }else
            return false;
    }
}
