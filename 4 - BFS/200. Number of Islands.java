// short and clean version

class Solution {
    public int numIslands(char[][] grid) {
        
        if (grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        
        int count = 0;
        for (int r = 0; r < grid.length; r++){
            for (int c = 0; c < grid[0].length; c++){
                if (grid[r][c] == '0'){
                    continue;
                }
                helper(grid, r, c);
                count++;
            }
        }
        return count;
    }
    
    private void helper(char[][] grid, int r, int c){
        
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length 
            || grid[r][c] == '0'){           
            return;
        }
        
        grid[r][c] = '0';
        
        helper(grid, r + 1, c);
        helper(grid, r - 1, c);
        helper(grid, r, c + 1);
        helper(grid, r, c - 1);
        
    }
}





// DFS
        // Trick
        // Setting the visited node as 0
        // so that we don't need another HashSet to keep track of visited slots
       
        // Trick
        // => row * numbers of Col + Col
        // using this formula so that each Int represent an unique slot
        // No need to store another node object or int[]



class Solution {
    public int numIslands(char[][] grid) {
        
        if (grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        
        int nRow = grid.length;
        int nCol = grid[0].length;
        int count = 0;
        for (int i = 0; i < nRow; i++){
            for (int j = 0; j < nCol; j++){
                // char '1' != int 1
                if(grid[i][j] == '1'){
                    dfs(i, j, grid);  
                    count++;
                }
            }
        }
        
        return count;
    }
    
    private void dfs(int i, int j, char[][] grid){
        
        int nCol = grid[0].length;
        int nRow = grid.length;
        // TRICK 
        // => row * numbers of Col + Col
        // using this formula so that each Int represent an unique slot
        // No need to store another node object or int[]
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i * nCol + j);

        // Trick
        // Setting the visited node as 0
        // so that we don't need another HashSet to keep track of visited slots
        grid[i][j] = '0';
        
        while (!queue.isEmpty()){
            int num = queue.poll();
            int col = num % nCol;
            int row = num / nCol;
            if (row + 1 < nRow && grid[row + 1][col] == '1'){
                queue.add((row + 1) * nCol + col);
                //change the '0' right here, or it will causes duplicates nodes in the queue 
                grid[row+1][col] = '0';
            }
            if (row - 1 >= 0 && grid[row - 1][col] == '1'){
                queue.add((row - 1) * nCol + col);
                grid[row-1][col] = '0';
            }
            if (col + 1 < nCol && grid[row][col + 1] == '1'){
                queue.add((row) * nCol + col + 1);
                grid[row][col+1] = '0';
            }
            if (col - 1 >= 0 && grid[row][col - 1] == '1'){
                queue.add((row) * nCol + col - 1);
                grid[row][col-1] = '0';
            }
            
            
        }
        
    }
    
}
