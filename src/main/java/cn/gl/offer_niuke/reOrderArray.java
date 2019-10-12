package cn.gl.offer_niuke;

public class reOrderArray {

    public void reOrderArray(int [] array) {
        if (array == null || array.length == 0)
            return;
        for (int i = 0; i < array.length; i++) {
            int reminder1 = array[i] & 0x1;
            if (reminder1 == 1) {
                continue;
            }
            for (int j = i+1; j < array.length; j++) {
                int reminder2 = array[j] & 0x1;
                if (reminder2 == 1) {
                    int temp = array[j];
                    for (int k = j; k > i; k--) {
                        array[k] = array[k -1];
                    }
                    array[i] = temp;
                    break;
                }
            }
        }
    }

    public void reOrderArray2(int [] array) {
        if (array == null || array.length == 0)
            return;
        for (int i = 0; i < array.length; i++) {
            int reminder1 = array[i] & 0x1;
            if (reminder1 == 0) {
                continue;
            }
            int curV = array[i];
            int j = i;
            for (; j > 0 && (array[j-1] & 0x1) == 0; j--) {
                array[j] = array[j-1];
            }
            array[j] = curV;
        }
    }



}
