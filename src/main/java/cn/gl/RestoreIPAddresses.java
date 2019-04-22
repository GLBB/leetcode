package cn.gl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class RestoreIPAddresses {

    public static void main(String[] args) {
        List<String> list = restoreIpAddresses("010010");
        System.out.println(list);

//        int i = Integer.parseInt("010");
//        System.out.println(i);
    }

    public static List<String> restoreIpAddresses(String s) {
        if (s.length() < 4)
            return Collections.emptyList();
        ArrayList<String> list = new ArrayList<>();
        int i = 1, j=2, k=3;
        while (k < s.length()){
            // 取 k 分割后一段是否合法，不合法，就加加
            String kstr = s.substring(k);
            if (!isValid(kstr)){
                k++;
                continue;
            }
            j=2;
            while (j<k){
                String jstr = s.substring(j, k);
                if (!isValid(jstr)){
                    j++;
                    continue;
                }
                i=1;
                while (i<j){
                    String istr = s.substring(i, j);
                    if (!isValid(istr)){
                        i++;
                        continue;
                    }
                    String prevstr = s.substring(0, i);
                    if (isValid(prevstr)){
                        String res = prevstr + "." + istr + "." + jstr + "." + kstr;
                        list.add(res);
                    }
                    i++;
                }
                j++;
            }
            k++;
        }
        return list;
    }

    public static boolean isValid(String str){
        if (str.length() > 1 && str.startsWith("0")){
            return false;
        }
        try {
            int i = Integer.parseInt(str);
            if (i>=0 && i<=255)
                return true;
            else
                return false;
        }catch (NumberFormatException e){
            System.out.println("exception");
            return false;
        }
    }

}
