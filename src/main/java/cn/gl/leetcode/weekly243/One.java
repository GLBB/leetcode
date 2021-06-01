package cn.gl.leetcode.weekly243;

public class One {

    public static void main(String[] args) {
        int i = Integer.parseInt("0001");
        System.out.println(i);
    }
    
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        Integer num1 = parseToInt(firstWord);
        Integer num2 = parseToInt(secondWord);
        Integer result = parseToInt(targetWord);
        return num1 + num2 == result;
    }
    
    private Integer parseToInt(String str) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            Integer value = ch - 'a';
            builder.append(value);
        }
        int num = Integer.parseInt(builder.toString());
        return num;
    }
}
