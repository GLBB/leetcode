package cn.gl.newketiba;

/**
 * NC109 岛屿数量
 */
public class NC109 {

    /**
     * 判断岛屿数量
     * @param grid char字符型二维数组 
     * @return int整型
     */
    public int solve (char[][] grid) {
        // write code here
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j< grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count += 1;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int rowIdx, int columnIdx) {
        if (rowIdx >= grid.length || columnIdx >= grid[0].length || rowIdx < 0 || columnIdx < 0) {
            return;
        }
        if (grid[rowIdx][columnIdx] == '1') {
            grid[rowIdx][columnIdx] = '2';
            // up down left right
            dfs(grid, rowIdx - 1, columnIdx);
            dfs(grid, rowIdx + 1, columnIdx);
            dfs(grid, rowIdx, columnIdx - 1);
            dfs(grid, rowIdx, columnIdx + 1);
            return;
        } else {
            return;
        }
    }
}
