package cn.gl;

public class ImplementStrStr {

    public static void main(String[] args) {
        ImplementStrStr solution = new ImplementStrStr();
        String h1 = "hello";
        String n1 = "";
        int i = solution.strStr(h1, n1);
        System.out.println(i);
    }

    public int strStr(String haystack, String needle) {
         return haystack.indexOf(needle);
    }
}
