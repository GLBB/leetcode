package cn.gl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;



// "9609 938 8247 82469735703560743981399"
// "9609 938 8248 24769735703560743981399" 正确
//  9609 938 8248 24769735703560743981399
// [9051,5526,2264,5041,1630,5906,6787,8382,4662,4532,6804,4710,4542,2116,7219,8701,8308,957,8775,4822,396,8995,8597,2304,8902,830,8591,5828,9642,7100,3976,5565,5490,1613,5731,8052,8985,2623,6325,3723,5224,8274,4787,6310,3393,78,3288,7584,7440,5752,351,4555,7265,9959,3866,9854,2709,5817,7272,43,1014,7527,3946,4289,1272,5213,710,1603,2436,8823,5228,2581,771,3700,2109,5638,3402,3910,871,5441,6861,9556,1089,4088,2788,9632,6822,6145,5137,236,683,2869,9525,8161,8374,2439,6028,7813,6406,7519]

// [9051,5526,2264,5041,1630,5906,6787,8382,4662,4532,6804,4710,4542,2116,7219,8701,8308,957,8775,4822,396,8995,8597,2304,8902,830,8591,5828,9642,7100,3976,5565,5490,1613,5731,8052,8985,2623,6325,3723,5224,8274,4787,6310,3393,78,3288,7584,7440,5752,351,4555,7265,9959,3866,9854,2709,5817,7272,43,1014,7527,3946,4289,1272,5213,710,1603,2436,8823,5228,2581,771,3700,2109,5638,3402,3910,871,5441,6861,9556,1089,4088,2788,9632,6822,6145,5137,236,683,2869,9525,8161,8374,2439,6028,7813,6406,7519]
// "995 9985 4964 29632 9579 5569 5259 051 89958985890288238775871870185978591838283748308308827481618052787813771758475277519744072727265721971071006861683682268046787640663256310614560285906582858175752573156385565552654905441522852245213513750414822478747104662455545424532434289408839763963946391038663723370035134023393328828692788270926232581243924362362304226421162109163016131603127210891014"
// "995 9985 4964 29632 9579 5569 5259 051 89958985890288238775871870185978591838283748308830827481618052787813771758475277519744072727265721971071006861683682268046787640663256310614560285906582858175752573156385565552654905441522852245213513750414822478747104662455545424532434289408839763963946391038663723370035134023393328828692788270926232581243924362362304226421162109163016131603127210891014"
/**
 * 不知道哪里错了
  */
public class LargestNumber {

    public static void main(String[] args) {
        int[] p1 = {10, 2};
        int[] p2 = {3,30,34,5,9};
        int[] p3 = {824,938,1399,5607,6973,5703,9609,4398,8247};
        int[] p4 = {121,12};
        String s = largestNumber(p4);
        System.out.println(s);
    }

    public static String largestNumber(int[] nums) {
        if (nums.length == 0)
            return "";
        int[] ints = Arrays.copyOf(nums, nums.length);
        Arrays.sort(ints);
        if (ints.length > 0) {
            if (ints[ints.length-1] == 0)
                return "0";
        }

        ArrayList[] lists = prepare(nums);
        StringBuilder sb = new StringBuilder();
        for (int i = lists.length -1; i >= 0 ; i--) {
            List<Integer> list = lists[i];
            if (list == null)
                continue;
            for (Integer number: list) {
                sb.append(number);
            }
        }
        return sb.toString();
    }

    public static ArrayList[] prepare(int[] nums) {
//        List<List<Integer>> lists = new ArrayList<>(10);
        ArrayList[] lists = new ArrayList[10];
        for (int i = 0; i < nums.length; i++) {
            String temp = nums[i] + "";
            char c = temp.charAt(0);
            int idx = c - '0';
            if (lists[idx] == null) {
                lists[idx] = new ArrayList<>();
                lists[idx].add(nums[i]);
            }else {
                lists[idx].add(nums[i]);
            }
        }
        for (int i = 0; i < lists.length; i++) {
            List<Integer> list = lists[i];
            if (list == null)
                continue;
            list.sort(comparator());
        }
        return lists;
    }

    /**
     * 将符合规则的大的排在前面
     * @return
     */
    public static Comparator<Integer> comparator(){
        return (i1, i2) -> {
            String temp1 = i1 + "";
            String temp2 = i2 + "";
            int idx = 0;
            while (idx < temp1.length() && idx < temp2.length()) {
                char c1 = temp1.charAt(idx);
                char c2 = temp2.charAt(idx);
                if (c1 < c2) {
                    return 1;
                }else if (c1 > c2) {
                    return -1;
                }
                idx++;
            }
            if (idx == temp1.length() && idx == temp2.length()) {
                return 0;
            }
            if (idx == temp1.length() && idx < temp2.length()) {
                char c1 = temp1.charAt(0);
                while (idx < temp2.length()) {
                    char c2 = temp2.charAt(idx++);
                    if (c1 > c2) {
                        return -1;
                    } else if (c1 < c2) {
                        return 1;
                    }
                }
                // 长度短的放前面
                return -1;
            }
            if (idx == temp2.length() && idx < temp1.length()) {
                char c2 = temp2.charAt(0);
                while (idx < temp1.length()) {
                    char c1 = temp1.charAt(idx++);
                    if (c1 > c2) {
                        return -1;
                    }else if (c1 < c2) {
                        return 1;
                    }
                }
                // 长度短的放前面
                return 1;
            }
            System.out.println("error");
            return 0;
        };
    }
}
