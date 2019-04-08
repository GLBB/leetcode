package cn.gl.ctrip;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Three {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            String line = scanner.nextLine();
            solution(line);
        }

//        String s = "5 /order/pnrList/pnrPriceList /order/pnrList/pnrPriceList/price /order/pnrList/pnrPriceList/price  /order/pnrList/pnrPriceList  /order/pnrList/pnrPriceList";
//        solution(s);

    }

    public static void solution(String line){
        String[] strArr = line.split(" ");
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < strArr.length; i++) {
            if (!"".equals(strArr[i])){
                list.add(strArr[i]);
            }
        }
        strArr = new String[list.size()];
        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = list.get(i);
        }

        // from 1 to strArr.length
        HashMap<String, Integer> map = new HashMap<>();
        StringBuilder result = new StringBuilder();
        for (int i = 1; i < strArr.length; i++) {
            // map.get()
            // if null apend 1(1)1, update map(remove end /)
            // if i, apend 1(i+1)1, update map
            String tempStr = strArr[i];
            if (strArr[i].endsWith("/")){
                tempStr = strArr[i].substring(0, strArr[i].length()-1);
            }
            Integer integer = map.get(tempStr);
            if (integer == null) {
                if (strArr[i].endsWith("/")){
                    map.put(strArr[i].substring(0, strArr[i].length()-1), 1);
                }else {
                    map.put(strArr[i], 1);
                }
                integer = 1;
            }else {
                integer += 1;
                if (strArr[i].endsWith("/")){
                    map.put(strArr[i].substring(0, strArr[i].length()-1), integer);
                }else {
                    map.put(strArr[i], integer);
                }
            }
            String[] split = strArr[i].substring(1).split("/");
            if (split.length >= 2) {
                split[0] = "1";
                split[split.length - 1] = "1";
                for (int j = 1; j < split.length-1; j++) {
                    split[j] = integer+"";
                }
            }else {
//                System.out.println("lenth < 2");
                result.append("1 ");
                continue;
            }
            StringBuilder subR = new StringBuilder();
            for (int j = 0; j < split.length; j++) {
                subR.append(split[j]);
            }
            result.append(subR.toString()+" ");
        }
        String r = result.toString();
        if (r.endsWith(" ")){
            r = r.substring(0, r.length() -1);
            System.out.println(r);
        }
    }

}
