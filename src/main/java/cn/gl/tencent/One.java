package cn.gl.tencent;

import java.util.ArrayList;
import java.util.Scanner;

public class One {

    /*
    YES
NO
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> res = new ArrayList<>();
        String yes = "YES";
        String no = "NO";
        while (scanner.hasNextLine()) {
            String t = scanner.nextLine();
            for (int i = 0; i < Integer.valueOf(t); i++) {
                String length = scanner.nextLine();
                String str = scanner.nextLine();
                boolean r = solution(str);
                if (r)
                    res.add(yes);
                else
                    res.add(no);
            }
            for (int i = 0; i < res.size(); i++) {
                System.out.println(res.get(i));
            }
        }
    }

    private static boolean solution(String str){
        if (str.length() < 11){
            return false;
        }
        int idx = str.indexOf('8');
        if (idx == -1)
            return false;
        if (str.length() - idx  >= 11)
            return true;
        else
            return false;

    }
}
