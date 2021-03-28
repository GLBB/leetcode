package cn.gl.newketiba;

import java.util.HashMap;

/**
 * https://www.nowcoder.com/practice/20ef0972485e41019e39543e8e895b7f?tpId=188&tqId=38285&rp=1&ru=%2Factivity%2Foj&qru=%2Fta%2Fjob-code-high-week%2Fquestion-ranking&tab=answerKey
 */
public class NC61 {

    public static void main(String[] args) {
        
    }

    public int[] twoSum (int[] numbers, int target) {
        // write code here
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < numbers.length; i++) {
            map.put(target - numbers[i], i);
        }
        for (int i = 0; i < numbers.length; i++) {
            Integer idx1 = map.get(numbers[i]);
            if (map.containsKey(numbers[i]) && idx1 != i) {
                result[0] = idx1 > i ? i : idx1;
                result[1] = idx1 > i ? idx1 : i;
                result[0] += 1;
                result[1] += 1;
                break;
            }
        }
        return result;
    }
    
    static class Node {
        int value;
        int idx;
    }
}
