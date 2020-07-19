// Leetcode 64 - Minimum Path Sum

class Solution {
    public int minPathSum(int[][] grid) {
        
        // build a minimum sum grid 
        
        int[][] dp = new int[grid.length][grid[0].length];
        
        for (int i = grid.length-1; i > -1; i--) {
            for (int j = grid[i].length-1; j > -1; j--) {
                
                if (i == grid.length-1 && j == grid[i].length-1) {
                    // base case
                    dp[i][j] = grid[i][j];
                } else if (j == grid[i].length-1) {
                    // right hand side
                    dp[i][j] = grid[i][j] + dp[i+1][j];
                    
                } else if (i == grid.length-1) {
                    // bottom
                    dp[i][j] = grid[i][j] + dp[i][j+1];

                } else {
                    // compute min of right and bottom
                    dp[i][j] = grid[i][j] + Math.min(dp[i+1][j], dp[i][j+1]);
                }
                
            }
        }
        
        return dp[0][0];
    }
}
