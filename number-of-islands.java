
//Leetcode 200 - Number of Islands
class Solution {
    int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    
    public int numIslands(char[][] grid) {
        // when you find an island -> turn island into water then continue from where you were
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    // we have found land!
                    
                    removeIsland(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    
    private void removeIsland(char[][] grid, int i, int j) {
        grid[i][j] = '0';
        
        for (int index = 0; index < directions.length; index++) {

            int a = i + directions[index][0];
            int b = j + directions[index][1];
            if (a < 0 || b < 0) continue;
            
            if (a < grid.length && b < grid[a].length && grid[a][b] == '1') removeIsland(grid, a, b);
            
        }
    }
}
