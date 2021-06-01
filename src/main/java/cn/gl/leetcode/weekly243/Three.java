package cn.gl.leetcode.weekly243;

import java.util.Arrays;

/**
 * 有BUG
 */
public class Three {

    public static void main(String[] args) {
//[10,63,95,16,85,57,83,95,6,29,71]
//[70,31,83,15,32,67,98,65,56,48,38,90,5]
        int[] servers = {3,3,2};
        int[] tasks = {1,2,3,2,1,2};
        int[] ans = new Three().assignTasks(servers, tasks);
        System.out.println(Arrays.toString(ans));
    }

    public int[] assignTasks(int[] servers, int[] tasks) {
        int sum = Arrays.stream(tasks).sum();
        int[][] taskSchedule = new int[servers.length][sum];
        int[] ans = new int[tasks.length];
        int seconds = 0;
        for (int i = 0; i < tasks.length; i++) {
            // 第 i 个 task
            // 找到空闲且权重最小的机器
            int server = freeServerMinPriority(taskSchedule, seconds, servers);
            if (server == -1) {
                seconds++;
                continue;
            }
            // 任务在该机器上运行
            runTask(taskSchedule, server, seconds, i, tasks[i]);
            // 添加ans
            ans[i] = server;
            // 增加 seconds
            seconds++;
        }
        return ans;
    }
    
    private void runTask(int[][] taskSchedule, int server, int iSeconds, int taskIdx, int spendTime) {
        for (int i = iSeconds; i < iSeconds + spendTime; i++) {
            taskSchedule[server][i] = taskIdx + 1;
        }
    }

    /**
     * 找到空闲且权重最小的机器
     * @param taskSchedule
     * @param iSeconds
     * @return
     */
    private int freeServerMinPriority(int[][] taskSchedule, int iSeconds, int[] priority) {
        int server = -1;
        Integer minPriority = null;
        for (int j = 0; j < taskSchedule.length; j++) {
            if (taskSchedule[j][iSeconds] > 0) {
                continue;
            }
            if (minPriority == null || minPriority > priority[j]) {
                minPriority = priority[j];
                server = j;
            }
        }
        return server;
    }

}
