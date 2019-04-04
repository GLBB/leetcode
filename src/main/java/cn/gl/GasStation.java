package cn.gl;

import java.util.ArrayList;

public class GasStation {



    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0, total = 0, start = 0;
        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
            total += gas[i] - cost[i];
            if (sum < 0) {
                start = i+1;
                sum = 0;
            }
        }
        return total < 0 ? -1: start;
    }



}
