package cn.gl.tencent;

import java.util.Scanner;

public class Scond {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {//注意while处理多个case
            String length = scanner.nextLine();
            String str = scanner.nextLine();
            int solution = solution(str);
            System.out.println(solution);
        }

//        int solution = solution("01010");
//        System.out.println();
    }

    public static int solution(String str){
        boolean flag = true;
        boolean ne = false;
        while (flag) {
            ne = false;
            if (str.contains("01")){
                str = str.replace("01", "");
                ne = true;
            }
            if (str.contains("10")) {
                str = str.replace("10", "");
                ne = true;
            }
            if (!ne) {
                break;
            }
        }
        return str.length();
    }
}
