package cn.gl;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 使用 Manacher 算法解决最长回文问题
 */
public class LongestPalindromicSubstring2 {

    public static void main(String[] args) {
        LongestPalindromicSubstring2 solution = new LongestPalindromicSubstring2();
        String s = "babad";
        String k = solution.longestPalindrome(s);
        System.out.println(k);

    }



    /**
     * 伪代码
     * sp = prepare(s)
     * rl = [] // rl 保存计算字符串中的回文数
     * pos = 0
     * mr = 0 // mr 是以前发现的关于 pos 的最右回文边界
     * for i in len(sp)
     *     j =  2 * pos - i, 即位置 j 是 i 关于 pos 的对称点
     *     rl[i] = min(rl[j], mr-i + 1) // 为什么是 min , 因为两种情况是或者关系
     *     // 扩展边界
     *     while sp[i + rl[i]] == sp[i - rl[i]] and i - rl[i] >= 0 and i + rl[i] < len(sp)
     *       rl[i]++
     *     // 尝试修改 mr, pos
     *     if (i + rl[i]-1 > mr)
     *         mr = i + rl[i] - 1
     *         pos = i
     * // 根据 pos 和 mr 返回结果
     * leftIdx =  pos - mr + 1
     * rightIdx = pos + mr - 1
     * sp.subString(leftIdx, rightIdx + 1)
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s.length() == 0)
            return "";
        String sp = prepare(s);
        int[] rl = new int[sp.length()];
        int pos = 0, mr = 0;
        int maxPos = 0, maxLen = 0;
        for (int i = 0; i < sp.length(); i++) {
            int j = 2 * pos - i;
            if (j >= 0)
                rl[i] = Math.min(rl[j], mr-i+1);
            else {
                rl[i] = 1;
                System.out.println("j less 0");
            }
            while (i-rl[i] >= 0 && i + rl[i] < sp.length() && sp.charAt(i-rl[i]) == sp.charAt(i + rl[i])) {
                rl[i] ++;
            }
            if (i + rl[i] - 1 > mr) {
                mr = i + rl[i] - 1;
                pos = i;
            }
            if (rl[i] > maxLen) {
                maxLen = rl[i];
                maxPos = i;
            }
        }
        int leftIdx = maxPos - rl[maxPos] + 1;
        int rightIdx = maxPos + rl[maxPos];
        System.out.println(sp);
        System.out.println(leftIdx + " " + rightIdx);
        String substring = sp.substring(leftIdx, rightIdx);
        return Arrays.stream(substring.split("#"))
                .reduce(String::concat)
                .orElse("");
    }

    private String prepare(String s){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append("#");
            sb.append(s.charAt(i));
        }
        sb.append("#");
        return sb.toString();
    }

}
