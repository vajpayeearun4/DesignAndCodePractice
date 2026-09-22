package final_prep.dsa.array.graph;

//https://leetcode.com/problems/number-of-islands/submissions/2143475628/
public class NoOfIsland {

    public int numIslands(char[][] grid) {
        int count = 0;
        int[][] directions = {
                {-1, 0},
                {1, 0},
                {0, -1},
                {0, 1}
        };

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, directions, i, j);
                }
            }
        }

        return count;

    }

    void dfs(char[][] grid, int[][] directions, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == '0') {
            return;
        }
        grid[row][col] = '0';
        for (int[] direction : directions) {
            dfs(grid, directions, row + direction[0], col + direction[1]);
        }
    }
}
