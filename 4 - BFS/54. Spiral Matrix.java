/*

DFS is a bit overkill, we can use iterative approach

*/
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        List<Integer> ans = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return ans;
        }
        
        helper(0, 0, matrix, 0, new boolean[matrix.length][matrix[0].length], ans);
        return ans;
    }
    
    private void helper(int rInd, int cInd, int[][] matrix,
                       int dirInd, boolean[][] visited, List<Integer> ans){
        
        visited[rInd][cInd] = true;
        ans.add(matrix[rInd][cInd]);
        
        int[] dirX = {0, 1, 0, -1};
        int[] dirY = {1, 0, -1, 0};
        
        for (int d = 0; d < 4; d++){
            dirInd = (dirInd + d) % 4;
            
            int newR = rInd + dirX[dirInd], newC = cInd + dirY[dirInd];
            if ( newR < 0 || newR >= matrix.length || 
                newC < 0 || newC >= matrix[0].length || visited[newR][newC]){
                continue;
            }
            
            helper(newR, newC, matrix, dirInd, visited, ans);
            return;
        }
        
        
    }
    
}
