package cn.gl.cqutcoj;

import java.util.HashMap;
import java.util.Scanner;

public class Decoder {

    static HashMap<String, String> map = new HashMap<>();


    public static void main(String[] args) {
        map.put("a", "1");
        map.put("b", "01");
        map.put("c", "001");

        Scanner scanner = new Scanner(System.in);


        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            String result = getResult(s);
            System.out.println(result);
        }
    }

    private static String getResult(String str){
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '0') {
                count++;
            }else{
                if (count == 0) {
                    sb.append("a");
                } else if (count == 1) {
                    sb.append("b");
                }else {
                    sb.append("c");
                }
                count = 0;
            }

        }

        return sb.toString();
    }

//    private String getChar(int idx, String str){
//        for (int i = 0; i < str.length(); i++) {
//
//        }
//    }


}
