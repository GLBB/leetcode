package cn.gl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 题目链接 难度中等
 */

public class RepeatedDNASequences {
    // 超时
//    public List<String> findRepeatedDnaSequences(String s) {
//        ArrayList<String> returnList = new ArrayList<>();
//
//        int length = s.length();
//
//        for (int i = 0; i <= length - 10; i++) {
//            int beginIndex = i;
//            int endIndex = i + 10;
//            String subString = s.substring(beginIndex, endIndex);
//            String proxyString = s.substring(beginIndex+1, length);
//
//            if(proxyString.contains(subString)){
//                if(!returnList.contains(subString)){
//                    returnList.add(subString);
//                }
//            }
//        }
//        return returnList;
//    }


    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        Long weight = (long)Math.pow(10, 9);

        for (int i=0; i <= s.length()-10; i++) {
            String pattern = s.substring(i, i+10);
            Long pattenHash = pattenHash(pattern);
            Long temp = pattenHash;

            for (int j=i+1; j<=s.length()-10; j++){
                Integer position = char2Number(s.charAt(j+9));
                Long nextHash = (temp % weight) *10 + position;
                temp = nextHash;

                if (nextHash.equals(pattenHash)) {
                    boolean include = false;
                    for (String str : result){
                        if (str.equals(pattern)){
                            include = true;
                        }
                    }
                    if (!include){
                        result.add(pattern);
                        break;
                    }
                }
            }

        }
        return result;
    }

    private Long pattenHash(String s){
        Long hash = 0L;
        for (int i=0; i < 10; i++){
            hash += char2Number(s.charAt(i)) * (long)Math.pow(10, 9-i);
        }
        return hash;
    }

    private Integer char2Number(Character ch){
        if (ch == 'A'){
            return 1;
        }else if (ch == 'C'){
            return 2;
        }else if (ch == 'G') {
            return 3;
        }else
            return 4;
    }

    public List<String> findRepeatedDnaSequences3(String s) {
        // A set of all the repeated sequences
        Set<String> sequences = new HashSet<>();
        // A set of all unique substrings
        Set<String> seqBank = new HashSet<>();
        int beginIndex = 0, endIndex = 10, len = s.length();
        String subSeq;


        while (endIndex <= len){
            subSeq = s.substring(beginIndex, endIndex);

            // If seqBank already contains the subSeq then add seq to sequences list
            if (!seqBank.add(subSeq)){
                sequences.add(subSeq);
            }
            beginIndex++;
            endIndex++;
        }
        return new ArrayList<String>(sequences);
    }

}
