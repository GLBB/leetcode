package cn.gl._360;

import java.util.ArrayList;

public class One {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static int string2int(String str) {
        ArrayList<Integer> list = new ArrayList<>();
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!(ch >= '0' && ch <= '9')){
                return 0;
            }
            result = result * 10 + (ch - '0');
        }
        return result;

    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
//        Scanner in = new Scanner(System.in);
//        int res;
//
//        String _str;
//        try {
//            _str = in.nextLine();
//        } catch (Exception e) {
//            _str = null;
//        }
//
//        res = string2int(_str);
//        System.out.println(String.valueOf(res));

        int i = string2int("0360");
        System.out.println(i);

    }
}