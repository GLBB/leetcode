package cn.gl.leetcode.weekly52;

import java.util.PriorityQueue;

public class Two {

    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(1);
        priorityQueue.add(2);
        System.out.println(priorityQueue.remove());
    }

    class SeatManager {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        public SeatManager(int n) {
            for (int i = 1; i <= n; i++) {
                priorityQueue.add(i);
            }
        }

        public int reserve() {
            Integer remove = priorityQueue.remove();
            return remove;
        }

        public void unreserve(int seatNumber) {
            priorityQueue.add(seatNumber);
        }
    }
}
