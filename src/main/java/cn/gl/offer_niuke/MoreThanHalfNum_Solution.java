package cn.gl.offer_niuke;

public class MoreThanHalfNum_Solution {

    public static void main(String[] args) {

    }

    public int MoreThanHalfNum_Solution(int [] array) {
        if (array == null || array.length == 0)
            return 0;
        int count = 1;
        int num = array[0];
        boolean flag = false;
        for (int i = 1; i < array.length; i++) {
            if (array[i] == num){
                count++;
                flag = false;
            } else{
                count--;
                if (count == 0){
                    num = array[i];
                    count = 1;
                    flag = true;
                }
            }
        }
        if (count == 1 && array.length == 1)
            return num;
        else if (count == 1 && flag)
            return 0;
        else
            return num;
    }

}
