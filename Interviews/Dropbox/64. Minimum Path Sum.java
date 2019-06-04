/*

DFS: O(2 ^ NM)
    Memoization will prune some, but will still TLE
    
DP: Time O(NM)
    Only need to loop through every number once, 
    because we only need to update from the upper number and the left number.
    
    Space: 
    if we create another int[][] pathSum, it is O(nm)
    if we do it in place, it is O(1)


*/

// DP in place

class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        
        // int[][] pathSum = new int[grid.length][grid[0].length];
        
        for (int r = 0; r <grid.length; r++){
            for (int c = 0; c < grid[0].length; c++){
                int up = r - 1 >= 0 ? grid[r - 1][c] : Integer.MAX_VALUE;
                int left = c - 1 >= 0 ? grid[r][c - 1] : Integer.MAX_VALUE;
                grid[r][c] = (r == 0 && c == 0) ? 
                    grid[r][c] : Math.min(up, left) + grid[r][c];
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
        
    }
}


// DP with int[][]pathSum

class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        
        int[][] pathSum = new int[grid.length][grid[0].length];
        
        for (int r = 0; r <grid.length; r++){
            for (int c = 0; c < grid[0].length; c++){
                int up = r - 1 >= 0 ? pathSum[r - 1][c] : Integer.MAX_VALUE;
                int left = c - 1 >= 0 ? pathSum[r][c - 1] : Integer.MAX_VALUE;
                pathSum[r][c] = (r == 0 && c == 0) ? 
                    grid[r][c] : Math.min(up, left) + grid[r][c];
            }
        }
        return pathSum[pathSum.length - 1][pathSum[0].length - 1];
        
    }
}



