package cn.gl.niels;


import org.junit.Test;

import java.util.Random;

public class QuickSortTest {

    QuickSort quickSort = new QuickSort();

    /**
     * junit 测试代码，测试快排是否正确。
     */
    @Test
    public void test(){
        for (int i = 0; i < 20; i++) {
            int[] arr = generateRandomArr();
            System.out.println("----------------------------------------arr:size: " + arr.length);
            long startTime = System.currentTimeMillis();
            System.out.println("初始化数组是否有序：" + isCorrect(arr));
            System.out.println("开始排序");
            quickSort.sort(arr);
            System.out.println("排序后的数组是否有序: " + isCorrect(arr));
            long endTime = System.currentTimeMillis();
            System.out.println("----------------------------------------sort:time: " + (endTime - startTime) + "ms");
        }
    }

    /**
     * 生成随机大小，值随机的数组。
     * @return
     */
    private int[] generateRandomArr(){
        Random random = new Random();
        int size = 0;
        while (size == 0 || size >= 10000000) {
            size = Math.abs(random.nextInt());
        }
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt();
        }
        return arr;
    }

    /**
     * 检测数组是否从小到大排序
     * @param arr
     * @return true：有序， false 无序。
     */
    private boolean isCorrect(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i] > arr[i+1])
                return false;
        }
        return true;
    }

}