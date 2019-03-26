package cn.gl;

public class NumberOfIslands {

    public static void main(String[] args) {

    }

    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j, grid.length, grid[i].length);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid,int x, int y, int rows, int cols) {
        if (x <0 || y <0 || x >= rows || y >= cols) {
            return;
        }
        grid[x][y] = 'y';
        if (x >0 && grid[x-1][y] == '1') {
            dfs(grid,x-1, y, rows, cols);
        }
        if (x <rows-1 && grid[x+1][y] == '1') {
            dfs(grid, x + 1, y, rows, cols);
        }
        if (y > 0 && grid[x][y-1] == '1') {
            dfs(grid, x, y-1, rows, cols);
        }
        if (y < cols-1 && grid[x][y+1] == '1') {
            dfs(grid, x, y+1, rows, cols);
        }

    }
}
