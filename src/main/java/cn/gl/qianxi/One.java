package cn.gl.qianxi;

import java.util.Scanner;

public class One {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            solution(line);
        }

    }

    //零一二三四五六七八九十百千万
    // 一万零千零百八十零
    // 一万零八十
    private static void solution(String str){
        String err = "错误输入";
        String res = "";
        try {
            int v = Integer.valueOf(str);
            int x = 10000;
            while (x != 0) {
                int k = v / x;
                if (k == 0 && res.equals("")) {
                    x = x/ 10;
                    continue;
                }
                if (k == 0 && res.charAt(res.length() - 1) != '零') {
                    res = res + "零";
                }else if (k == 0){
                    x = x/ 10;
                    continue;
                }
                String v1 = convert(k);
                String v2 = convert(x);
                if (x != 1) {
                    res = res + v1 + v2;
                }else {
                    res = res + v1;
                }
                // 判断 v 之后是否包含0
                String temp = v + "";
                if (temp.length() > 2 && temp.charAt(1) == '0'){
                    res += '零';
                }
                v = v - k * x;
                x = x / 10;
            }
            while (res.charAt(res.length() - 1) == '零')
                res = res.substring(0, res.length()-1);
            // 去掉末尾零
            System.out.println(res);
        }catch (Exception e) {
            System.out.println(err);
        }


    }

    private static String convert(int v){
        switch (v) {
            case 0:
                return  "零";
            case 1:
                return "一";
            case 2:
                return "二";
            case 3:
                return "三";
            case 4:
                return "四";
            case 5:
                return "五";
            case 6:
                return "六";
            case 7:
                return "七";
            case 8:
                return "八";
            case 9:
                return "九";
            case 10000:
                return "万";
            case 1000:
                return "千";
            case 100:
                return "百";
            case 10:
                return "十";
            default:
                    return "";
        }
    }
}
