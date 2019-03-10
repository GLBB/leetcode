package cn.gl;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        ContainerWithMostWater solution = new ContainerWithMostWater();
        int[] para1 = {1,8,6,2,5,4,8,3,7};
        int result = solution.maxArea(para1);
        System.out.println(result);
    }

    public int maxArea(int[] height) {
        int i = 0, j = height.length-1, maxArea = 0;
        while (i <= j) {
            int temp = (j - i) * Math.min(height[i], height[j]);
            if (temp > maxArea) {
                maxArea = temp;
            }
            if (height[i] < height[j]) {
                i++;
            }else {
                j--;
            }
        }
        return maxArea;
    }
}


