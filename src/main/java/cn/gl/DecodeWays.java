package cn.gl;

/**
 * 未做出来
 * “00” 需考虑
 */
public class DecodeWays {

    public static void main(String[] args) {
        int i = numDecodings("10");
        System.out.println(i);
    }

    public static int numDecodings(String s) {
        if (s.length() == 0 || s.equals("0"))
            return 0;
        int[] arr = new int[s.length()+1];
        arr[0] = 0;
        for (int i = 1; i < arr.length; i++) {
            int v1 = Integer.parseInt(s.charAt(i-1)+"");
            if (v1 == 0){
                arr[i] = arr[i-1];
                continue;
            }
            Integer v2 = null;
            if (i < arr.length - 1)
                v2 = Integer.parseInt(s.charAt(i)+"");
            if (v2 != null && v2 == 0){
                // i, i+1 值都算出来
                arr[i] =  arr[i+1] = arr[i-1];
                i++;
            }else {
                int prev = Integer.parseInt(s.charAt(i-2)+"");
                int temp = prev * 10 + v1;
                if (1<=temp && temp <= 26){
                    arr[i] = arr[i-1] + 1;
                }else
                    arr[i] = arr[i-1];
            }
        }
        return arr[arr.length-1];
    }
}
