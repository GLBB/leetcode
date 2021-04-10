package cn.gl.newketiba;

/**
 * 斐波拉切数列
 * 
 * 0 1 1 2 3
 * 
 * 2
 * 0 1 1
 */
public class NC65 {

    public int Fibonacci(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        int sum = 0;
        int prev = 0;
        int cur = 1;
        while (n > 0) {
            sum = prev + cur;
            prev = cur;
            cur = sum;
            n --;
        }
        return prev;
        
    }
}
