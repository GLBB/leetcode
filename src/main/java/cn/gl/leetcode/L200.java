package cn.gl.leetcode;

/**
 * 200. 岛屿数量
 */
public class L200 {

    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    expandGrid(grid, i, j);
                }
            }
        }
        return count;
    }

    private void expandGrid(char[][] grid, int i, int j) {
        if (i >= grid.length || i < 0 || j >= grid[i].length || j < 0 || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '0';
        expandGrid(grid, i-1, j);
        expandGrid(grid, i+1, j);
        expandGrid(grid, i, j - 1);
        expandGrid(grid, i, j + 1);
    }
}
