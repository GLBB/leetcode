package cn.gl.newketiba;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NC127 {

    public static void main(String[] args) {
        new NC127().LCS("2LQ74WK8Ld0x7d8FP8l61pD7Wsz1E9xOMp920hM948eGjL9Kb5KJt80","U08U29zzuodz16CBZ8xfpmmn5SKD80smJbK83F2T37JRqYfE76vh6hrE451uFQ100ye9hog1Y52LDk0L52SuD948eGjLz0htzd5YF9J1Y6oI7562z4T2");
    }
    /**
     * longest common substring
     * @param str1 string字符串 the string
     * @param str2 string字符串 the string
     * @return string字符串
     */
    public String LCS (String str1, String str2) {
        // write code here
        HashMap<String, List<Integer>> index = new HashMap();
        for (int i = 0; i < str2.length(); i++) {
            List<Integer> list = index.get(str2.charAt(i)+ "");
            if (list == null) {
                list = new ArrayList();
                index.put(str2.charAt(i)+ "", list);
            }
            list.add(i);
        }
        int maxLength = 0;
        String maxStr = "";
        for(int i = 0; i < str1.length(); i++) {
            String key = str1.charAt(i) + "";
            List<Integer> list = index.get(key);
            for (int j = 0; j < list.size(); j++) {
                int startIdx2 = list.get(j);
                int startIdx1 = i;
                StringBuilder tempStr = new StringBuilder();
                while(
                    startIdx1 < str1.length() &&
                        startIdx2 < str2.length() &&
                        str1.charAt(startIdx1) == str2.charAt(startIdx2)
                ) {
                    tempStr.append(str1.charAt(startIdx1));
                    startIdx1++;
                    startIdx2++;
                }
                if (tempStr.length() > maxLength) {
                    maxStr = tempStr.toString();
                    maxLength = maxStr.length();
                }
            }
        }
        return maxStr;
    }
}
